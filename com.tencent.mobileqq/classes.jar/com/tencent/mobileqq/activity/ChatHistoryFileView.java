package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter;
import com.tencent.mobileqq.adapter.ChatHistoryFileAdapter.OnSelectedListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.TencentDocData;
import com.tencent.mobileqq.filebrowser.IFileBrowserModel;
import com.tencent.mobileqq.filebrowser.IFileBrowserService;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.FileManagerProxy;
import com.tencent.mobileqq.filemanager.openbrowser.FileBrowserParam;
import com.tencent.mobileqq.filemanager.openbrowser.FileModelAdapter;
import com.tencent.mobileqq.filemanager.openbrowser.RecentMediaFileBrowseProcessor;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.FileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.filemanager.util.QfileTimeUtils;
import com.tencent.mobileqq.mediabrowser.IMediaBrowserService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MqqWeakReferenceHandler;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChatHistoryFileView
  extends ChatHistoryViewBase
  implements Handler.Callback, ChatHistoryFileAdapter.OnSelectedListener
{
  final String a = "ChatHistoryFileView<FileAssistant>";
  QQAppInterface b;
  Context c;
  View d;
  XListView e;
  LinearLayout f;
  ChatHistoryFileAdapter g;
  boolean h = false;
  View.OnClickListener i;
  View.OnClickListener j;
  protected final MqqHandler k = new MqqWeakReferenceHandler(Looper.getMainLooper(), this, true);
  private String l;
  private List<Object> m;
  private FMObserver n = null;
  private int o;
  
  private ArrayList<TencentDocData> a(JSONObject paramJSONObject)
  {
    try
    {
      if (paramJSONObject.getInt("retcode") == 0)
      {
        ArrayList localArrayList = new ArrayList();
        paramJSONObject = paramJSONObject.getJSONArray("recent_file_list");
        int i1 = 0;
        while (i1 < paramJSONObject.length())
        {
          JSONObject localJSONObject1 = (JSONObject)paramJSONObject.get(i1);
          TencentDocData localTencentDocData = new TencentDocData();
          JSONObject localJSONObject2 = (JSONObject)localJSONObject1.get("doc_info");
          localTencentDocData.peerTips = localJSONObject1.getString("peer_tips");
          TencentDocData.obtainFromJsonObject(localJSONObject2, (JSONObject)localJSONObject1.get("qq_share_common_msg"), localTencentDocData);
          localArrayList.add(localTencentDocData);
          i1 += 1;
        }
        return localArrayList;
      }
    }
    catch (JSONException paramJSONObject)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ChatHistoryFileView<FileAssistant>", 1, paramJSONObject.getMessage());
      }
    }
    return null;
  }
  
  private void a(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    paramLinkedHashMap = paramLinkedHashMap.values().iterator();
    while (paramLinkedHashMap.hasNext()) {
      Collections.sort((List)paramLinkedHashMap.next(), new ChatHistoryFileView.2(this));
    }
  }
  
  private void a(JSONObject paramJSONObject, LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramJSONObject != null)
    {
      paramJSONObject = a(paramJSONObject);
      if (((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).isCollectionNotEmpty(paramJSONObject))
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("tencent doc size: ");
          ((StringBuilder)localObject).append(paramJSONObject.size());
          QLog.d("ChatHistoryFileView<FileAssistant>", 1, ((StringBuilder)localObject).toString());
        }
        paramJSONObject = paramJSONObject.iterator();
        while (paramJSONObject.hasNext())
        {
          localObject = (TencentDocData)paramJSONObject.next();
          String str = QfileTimeUtils.a(((TencentDocData)localObject).aioTime);
          if (!paramLinkedHashMap.containsKey(str)) {
            paramLinkedHashMap.put(str, new ArrayList());
          }
          ((List)paramLinkedHashMap.get(str)).add(localObject);
        }
        FileManagerReporter.a("0X8009A9E");
      }
      a(paramLinkedHashMap);
    }
    paramJSONObject = new Message();
    paramJSONObject.what = 1;
    paramJSONObject.obj = paramLinkedHashMap;
    this.k.sendMessage(paramJSONObject);
  }
  
  private void b()
  {
    ThreadManager.post(new ChatHistoryFileView.1(this), 8, null, true);
  }
  
  private void b(LinkedHashMap<String, List<Object>> paramLinkedHashMap)
  {
    if (paramLinkedHashMap == null) {
      return;
    }
    Object localObject = this.m;
    if (localObject != null)
    {
      ((List)localObject).clear();
      localObject = paramLinkedHashMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        this.m.add(str);
        this.m.addAll((Collection)paramLinkedHashMap.get(str));
      }
    }
  }
  
  private void c()
  {
    b(j());
    k();
  }
  
  private LinkedHashMap<String, List<Object>> j()
  {
    Object localObject1 = new ArrayList(this.b.getFileManagerProxy().a(this.l));
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)((Iterator)localObject1).next();
      if ((localFileManagerEntity != null) && (!localFileManagerEntity.bDelInAio))
      {
        int i1 = this.o;
        if (i1 == 1 ? (localFileManagerEntity.nFileType == 3) && (localFileManagerEntity.nFileType == 9) && (localFileManagerEntity.nFileType == 7) && (localFileManagerEntity.nFileType == 6) && (localFileManagerEntity.nFileType == 10) : (i1 != 3) || ((localFileManagerEntity.nFileType != 3) && (localFileManagerEntity.nFileType != 9) && (localFileManagerEntity.nFileType != 7) && (localFileManagerEntity.nFileType != 6) && (localFileManagerEntity.nFileType != 0) && (localFileManagerEntity.nFileType != 10) && (localFileManagerEntity.nFileType != 2)))
        {
          if (QLog.isDevelopLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("ChatHistory Query Entity[");
            ((StringBuilder)localObject2).append(localFileManagerEntity.getId());
            ((StringBuilder)localObject2).append("] SessionId:");
            ((StringBuilder)localObject2).append(localFileManagerEntity.nSessionId);
            QLog.d("ChatHistoryFileView<FileAssistant>", 1, ((StringBuilder)localObject2).toString());
          }
          Object localObject2 = QfileTimeUtils.a(localFileManagerEntity.srvTime);
          if (!localLinkedHashMap.containsKey(localObject2)) {
            localLinkedHashMap.put(localObject2, new ArrayList());
          }
          ((List)localLinkedHashMap.get(localObject2)).add(localFileManagerEntity);
        }
      }
    }
    return localLinkedHashMap;
  }
  
  private void k()
  {
    List localList = this.m;
    if ((localList != null) && (localList.size() != 0))
    {
      this.f.setVisibility(8);
      this.e.setVisibility(0);
    }
    else
    {
      this.f.setVisibility(0);
      this.e.setVisibility(8);
    }
    this.d.setVisibility(0);
    this.g.notifyDataSetChanged();
  }
  
  private void l()
  {
    if (this.j != null) {
      return;
    }
    this.j = new ChatHistoryFileView.3(this);
  }
  
  private void m()
  {
    if (this.i != null) {
      return;
    }
    this.i = new ChatHistoryFileView.4(this);
  }
  
  public View a()
  {
    return this.d;
  }
  
  public void a(int paramInt)
  {
    this.o = paramInt;
    if (this.o == 1)
    {
      b();
      return;
    }
    c();
  }
  
  public void a(Intent paramIntent, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    m();
    l();
    this.l = paramIntent.getStringExtra("uin");
    this.m = new ArrayList();
    this.g = new ChatHistoryFileAdapter(this.c, this.m, this.j, this.i, this);
    this.g.a(this);
    this.d = View.inflate(this.c, 2131627049, null);
    this.e = ((XListView)this.d.findViewById(2131437330));
    this.f = ((LinearLayout)this.d.findViewById(2131439376));
    this.e.setVisibility(8);
    this.f.setVisibility(8);
    this.e.setAdapter(this.g);
    paramIntent = this.d.findViewById(2131433134);
    paramQQAppInterface = paramIntent.findViewById(2131441950);
    paramIntent.setVisibility(8);
    paramQQAppInterface.setVisibility(8);
  }
  
  public void a(TencentDocData paramTencentDocData)
  {
    if (i())
    {
      if (this.D.b(paramTencentDocData))
      {
        this.D.c(paramTencentDocData);
      }
      else
      {
        if (this.D.b()) {
          return;
        }
        this.D.a(paramTencentDocData);
      }
    }
    else
    {
      ((ITeamWorkUtils)QRoute.api(ITeamWorkUtils.class)).clickWebTDDoc(paramTencentDocData.docUrl, this.c);
      FileManagerReporter.a("0X8009A9F");
    }
    this.g.notifyDataSetChanged();
  }
  
  public void a(FileManagerEntity paramFileManagerEntity)
  {
    this.b.getFileManagerDataCenter().b();
    if (i())
    {
      if (this.D.b(paramFileManagerEntity))
      {
        this.D.c(paramFileManagerEntity);
      }
      else
      {
        if (this.D.b()) {
          return;
        }
        this.D.a(paramFileManagerEntity);
      }
      if ((paramFileManagerEntity.cloudType == 3) && (!FileUtil.b(paramFileManagerEntity.getFilePath())))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(FileManagerUtil.j(paramFileManagerEntity.fileName));
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131899832));
        FMToastUtil.a(((StringBuilder)localObject).toString());
        this.D.c(paramFileManagerEntity);
      }
      this.g.notifyDataSetChanged();
      return;
    }
    boolean bool = p();
    int i1 = 2;
    if (!bool)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatHistoryFileView<FileAssistant>", 2, "click too fast , wait a minute.");
      }
      return;
    }
    q();
    Object localObject = new FileManagerReporter.FileAssistantReportData();
    ((FileManagerReporter.FileAssistantReportData)localObject).b = "file_viewer_in";
    ((FileManagerReporter.FileAssistantReportData)localObject).c = 73;
    ((FileManagerReporter.FileAssistantReportData)localObject).d = FileUtil.a(paramFileManagerEntity.fileName);
    ((FileManagerReporter.FileAssistantReportData)localObject).e = paramFileManagerEntity.fileSize;
    FileManagerReporter.a(this.b.getCurrentAccountUin(), (FileManagerReporter.FileAssistantReportData)localObject);
    FileManagerReporter.a("0X8004AE4");
    if ((paramFileManagerEntity.nFileType != 0) && (paramFileManagerEntity.nFileType != 2))
    {
      localObject = new FileModelAdapter(this.b, paramFileManagerEntity);
      if (paramFileManagerEntity.peerType != 0) {
        if (paramFileManagerEntity.peerType == 3000) {
          i1 = 6;
        } else {
          i1 = 7;
        }
      }
      paramFileManagerEntity = new FileBrowserParam().a(i1).a(this.l);
      ((IFileBrowserService)QRoute.api(IFileBrowserService.class)).browserFile(this.c, (IFileBrowserModel)localObject, paramFileManagerEntity);
      return;
    }
    paramFileManagerEntity = new RecentMediaFileBrowseProcessor(this.b, this.l, paramFileManagerEntity).a();
    ((IMediaBrowserService)QRoute.api(IMediaBrowserService.class)).browserFile(this.c, paramFileManagerEntity);
  }
  
  public boolean b(FileManagerEntity paramFileManagerEntity)
  {
    return this.D.b(paramFileManagerEntity);
  }
  
  public void d()
  {
    if (this.n != null) {
      return;
    }
    this.n = new ChatHistoryFileView.5(this);
    this.b.getFileManagerNotifyCenter().addObserver(this.n);
  }
  
  public void e()
  {
    if (this.n != null)
    {
      this.b.getFileManagerNotifyCenter().deleteObserver(this.n);
      this.n = null;
    }
  }
  
  public void f()
  {
    if (this.n != null)
    {
      this.b.getFileManagerNotifyCenter().deleteObserver(this.n);
      this.n = null;
    }
    super.f();
  }
  
  public void g()
  {
    this.h = true;
    this.g.a(true);
    this.g.notifyDataSetChanged();
  }
  
  public void h()
  {
    this.h = false;
    this.g.a(false);
    this.g.notifyDataSetChanged();
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 1) {
      return false;
    }
    b((LinkedHashMap)paramMessage.obj);
    k();
    return true;
  }
  
  public boolean i()
  {
    return this.h;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistoryFileView
 * JD-Core Version:    0.7.0.1
 */