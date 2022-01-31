package com.tencent.biz.qqstory.takevideo.music;

import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.download.DownloadProgressListener;
import com.tencent.biz.qqstory.base.download.DownloaderImp;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.AddressDataProvider;
import com.tencent.biz.qqstory.model.AddressDataProvider.AddressInfo;
import com.tencent.biz.qqstory.model.DataProvider.DataUpdateListener;
import com.tencent.biz.qqstory.model.DataProviderManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspGetMusicListConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.MusicConfigInfo;
import com.tencent.biz.qqstory.network.request.GetMusicConfigRequest;
import com.tencent.biz.qqstory.network.response.GetMusicConfigResponse;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Timer;
import java.util.concurrent.ConcurrentHashMap;
import okw;
import okx;
import oky;
import okz;
import ola;
import olb;

@TargetApi(11)
public class EditVideoMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, DownloadProgressListener, CmdTaskManger.CommandCallback, MusicHorizontalSeekView.SeekListener
{
  public int a;
  protected long a;
  protected BroadcastReceiver a;
  public Handler a;
  public View a;
  protected GridView a;
  public ProgressBar a;
  public TextView a;
  public DownloaderImp a;
  private DataProvider.DataUpdateListener a;
  public EditVideoMusic a;
  protected EditVideoParams a;
  public BlessVoiceChangeManager a;
  protected EditVideoMusicDialog.MusicPlayTask a;
  public MusicGridAdapter a;
  public MusicHorizontalSeekView a;
  public QQStoryMusicInfo a;
  protected Timer a;
  protected ConcurrentHashMap a;
  public final boolean a;
  public int b;
  protected long b;
  public View b;
  public TextView b;
  protected ConcurrentHashMap b;
  public boolean b;
  protected int c;
  protected View c;
  protected TextView c;
  public boolean c;
  protected volatile int d;
  protected TextView d;
  public boolean d;
  protected TextView e;
  protected boolean e;
  protected TextView f;
  
  public EditVideoMusicDialog(Context paramContext, EditVideoMusic paramEditVideoMusic, boolean paramBoolean1, int paramInt, EditVideoParams paramEditVideoParams, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131624484);
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    this.jdField_a_of_type_Long = 1000L;
    this.jdField_a_of_type_AndroidOsHandler = new okw(this);
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = new oky(this);
    this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener = new olb(this);
    super.requestWindowFeature(1);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    this.jdField_c_of_type_Int = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_Int;
    this.jdField_c_of_type_Boolean = paramBoolean2;
    this.jdField_e_of_type_Boolean = paramBoolean3;
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.x = 0;
    paramContext.y = 0;
    paramContext.width = -1;
    paramContext.height = UIUtils.b(getContext());
    paramContext.windowAnimations = 2131624200;
    paramContext.gravity = 83;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
    {
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.g))
      {
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(11);
        return;
      }
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
  }
  
  private void h()
  {
    int j = 1;
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    int i = j;
    if (localQQStoryMusicInfo != null)
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo != null)
      {
        if ((localQQStoryMusicInfo.jdField_b_of_type_Int == 3) || (localQQStoryMusicInfo.jdField_b_of_type_Int == 2)) {
          break label99;
        }
        i = j;
      }
    }
    while ((this.jdField_e_of_type_Boolean) && (i != 0))
    {
      DialogUtil.a(getContext(), 230).setMessage("更改背景音乐将会取消当前的音乐标签，确定更改？").setPositiveButton("确定", new ola(this)).setNegativeButton("取消", new okz(this)).show();
      return;
      label99:
      i = j;
      if (localQQStoryMusicInfo.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo.jdField_a_of_type_JavaLangString)) {
        i = 0;
      }
    }
    dismiss();
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int < 5000) {
      return 5000;
    }
    return this.jdField_a_of_type_Int;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i = (int)(this.jdField_c_of_type_AndroidWidgetTextView.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i);
    this.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.jdField_d_of_type_AndroidWidgetTextView.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i * 2);
    this.jdField_d_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    c();
    b(paramInt1, paramInt2, paramInt3);
    if (this.jdField_a_of_type_Boolean) {}
    for (String str = "2";; str = "1")
    {
      StoryReportor.a("video_edit", "cut_music", 0, 0, new String[] { str, "", "", "" });
      VideoEditReport.a("0X80076DA");
      return;
    }
  }
  
  public void a(Context paramContext)
  {
    Object localObject = LayoutInflater.from(paramContext).inflate(2130970785, null);
    super.setContentView((View)localObject);
    label359:
    int i;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 4);
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)((View)localObject).findViewById(2131369046));
      this.jdField_b_of_type_AndroidViewView = ((View)localObject).findViewById(2131369050);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView = ((MusicHorizontalSeekView)((View)localObject).findViewById(2131369051));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicHorizontalSeekView.setOnSeekListener(this);
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371915));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369052));
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131369053));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131371918));
      this.f = ((TextView)super.findViewById(2131371919));
      this.jdField_e_of_type_AndroidWidgetTextView.setOnClickListener(this);
      this.f.setOnClickListener(this);
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)((View)localObject).findViewById(2131371914));
      this.jdField_b_of_type_AndroidWidgetTextView.setText("");
      this.jdField_a_of_type_AndroidViewView = ((View)localObject).findViewById(2131369047);
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)((View)localObject).findViewById(2131371917));
      this.jdField_a_of_type_AndroidWidgetGridView.setNumColumns(-1);
      this.jdField_a_of_type_AndroidWidgetGridView.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(this);
      this.jdField_c_of_type_AndroidViewView = ((View)localObject).findViewById(2131371913);
      this.jdField_c_of_type_AndroidViewView.setOnClickListener(this);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter = new MusicGridAdapter(paramContext, this.jdField_a_of_type_AndroidWidgetGridView, this.jdField_a_of_type_Boolean, a(this.jdField_c_of_type_Int));
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(null);
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if (localObject == null)
      {
        EditVideoMusic localEditVideoMusic = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
        if (!this.jdField_a_of_type_Boolean) {
          break label691;
        }
        paramContext = QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
        localEditVideoMusic.a(paramContext);
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo = ((QQStoryMusicInfo)localObject);
      this.jdField_d_of_type_Boolean = EditVideoPartManager.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_b_of_type_Int, 512);
      if (this.jdField_d_of_type_Boolean) {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager = new BlessVoiceChangeManager(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic, this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams, this.jdField_a_of_type_AndroidOsHandler);
      }
      if (a(this.jdField_c_of_type_Int))
      {
        if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList.isEmpty())) {
          break label698;
        }
        i = 1;
        label453:
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = QQStoryMusicInfo.a(getContext());
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
        if (i != 0)
        {
          if (!NetworkUtil.d(getContext())) {
            break label703;
          }
          this.jdField_b_of_type_Long = System.currentTimeMillis();
          paramContext = new GetMusicConfigRequest();
          CmdTaskManger.a().a(paramContext, this);
        }
      }
      label513:
      paramContext = (AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1);
      localObject = (AddressDataProvider.AddressInfo)paramContext.a();
      if (localObject == null) {
        break label730;
      }
      SLog.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "get address from cache.");
      if (paramContext.a((AddressDataProvider.AddressInfo)localObject))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a();
        if (QLog.isColorLevel()) {
          QLog.d("zivonchen", 2, "isInternationalUser --------------------1");
        }
      }
    }
    for (;;)
    {
      paramContext = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      paramContext.addAction("action_music_start");
      paramContext.addAction("action_music_refresh_list");
      getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, paramContext);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "mVideoLength = " + this.jdField_a_of_type_Int);
      }
      return;
      if (this.jdField_a_of_type_Int < 5000)
      {
        this.jdField_a_of_type_Long = (this.jdField_a_of_type_Int / 6);
        break;
      }
      this.jdField_a_of_type_Long = 1000L;
      break;
      label691:
      paramContext = QQStoryMusicInfo.jdField_b_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo;
      break label359;
      label698:
      i = 0;
      break label453;
      label703:
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      QQToast.a(getContext(), "当前无网络", 0).a();
      break label513;
      label730:
      SLog.b("Q.qqstory.publish.edit.EditVideoMusicDialog", "get address from net.");
      paramContext.a(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
      paramContext.b();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "isInternationalUser request poi --------------------0");
      }
    }
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("onCmdRespond = ").append(System.currentTimeMillis() - this.jdField_b_of_type_Long).append(", errorMsg = ");
      if (paramErrorMessage != null) {
        break label206;
      }
    }
    label206:
    for (paramGetMusicConfigRequest = "null";; paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage())
    {
      QLog.d("zivonchen", 2, paramGetMusicConfigRequest);
      StoryReportor.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.jdField_b_of_type_Long), "", "", "" });
      if ((paramErrorMessage == null) || (!paramErrorMessage.isFail())) {
        break;
      }
      paramGetMusicConfigRequest = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(7);
      paramGetMusicConfigRequest.obj = ("onCmdRespond error = " + paramErrorMessage.getErrorMessage());
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramGetMusicConfigRequest);
      StoryReportor.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramGetMusicConfigResponse = paramGetMusicConfigResponse.a;
    int j = paramGetMusicConfigResponse.music_config.size();
    paramGetMusicConfigRequest = new ArrayList(j);
    if (j > 0)
    {
      int i = 0;
      while (i < j)
      {
        paramGetMusicConfigRequest.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigResponse.music_config.get(i)));
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetMusicConfigResponse = new StringBuffer();
        paramGetMusicConfigResponse.append("GetMusicConfigResponse size = " + j);
        i = 0;
        while (i < j)
        {
          paramErrorMessage = (QQStoryMusicInfo)paramGetMusicConfigRequest.get(i);
          paramGetMusicConfigResponse.append(", " + i + ": title = " + paramErrorMessage.jdField_b_of_type_JavaLangString + ", audioUrl = " + paramErrorMessage.jdField_d_of_type_JavaLangString);
          i += 1;
        }
        QLog.d("zivonchen", 2, paramGetMusicConfigResponse.toString());
      }
    }
    for (;;)
    {
      StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(j), "", "", "" });
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = paramGetMusicConfigRequest;
      QQStoryMusicInfo.a(getContext(), paramGetMusicConfigRequest);
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      return;
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "onCmdRespond data is NULL!!!!!");
      }
    }
  }
  
  public void a(String paramString)
  {
    Object localObject2;
    Object localObject1;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject2 = QQStoryBGMusicUtils.a(paramString);
      localObject1 = (String)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label157;
      }
    }
    while (com.tencent.biz.qqstory.utils.FileUtils.e((String)localObject1))
    {
      if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
      {
        com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
        this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
      }
      localObject2 = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localObject2 != null) && (paramString.equals(((QQStoryMusicInfo)localObject2).jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a((String)localObject1);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "exists audio_url = " + paramString + ", path = " + (String)localObject1);
      }
      return;
      label157:
      localObject1 = localObject2;
    }
    if (!NetworkUtil.g(BaseApplication.getContext()))
    {
      f();
      QQToast.a(BaseApplication.getContext(), 2131430033, 0).a();
      return;
    }
    this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ThreadManager.post(new okx(this, paramString, (String)localObject2), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    String str = QQStoryBGMusicUtils.a(paramString);
    if (paramInt == 0)
    {
      this.jdField_d_of_type_Int = 0;
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onDownloadFinish() url = " + paramString);
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, str);
      QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((localQQStoryMusicInfo != null) && (paramString.equals(localQQStoryMusicInfo.jdField_d_of_type_JavaLangString)))
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(str);
        this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(2);
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    for (;;)
    {
      if (QLog.isColorLevel())
      {
        long l = ((Long)this.jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString)).longValue();
        QLog.d("zivonchen", 2, "onDownloadFinish errCode = " + paramInt + ", name = " + com.tencent.biz.qqstory.utils.FileUtils.b(paramString) + ", downloadTime = " + (System.currentTimeMillis() - l) + ", fileSize = " + com.tencent.biz.qqstory.utils.FileUtils.a(str) + new StringBuilder().append(", url = ").append(paramString).toString());
      }
      return;
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      VideoEditReport.a("0X80076D9");
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.jdField_d_of_type_Int * 0.05F)
    {
      this.jdField_d_of_type_Int += 1;
      paramString = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "onProgress() mIndex = " + this.jdField_d_of_type_Int + ", progress = " + f1 + ", cur = " + paramLong1 + ", size = " + paramLong2);
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("zivonchen", 2, "onDownloadStart() url = " + paramString1 + ", dstPath = " + paramString2);
    }
    this.jdField_d_of_type_Int = 0;
    paramString1 = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(9);
    paramString1.arg1 = 0;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(paramString1);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.j();
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.k();
  }
  
  protected boolean a(int paramInt)
  {
    boolean bool = true;
    if (paramInt == 5) {
      bool = false;
    }
    return bool;
  }
  
  public void b()
  {
    e();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.i();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    int i = 1000;
    int j = (paramInt2 - paramInt1) / 1000 * 1000;
    if (j < 1000) {}
    for (;;)
    {
      j = i;
      if (this.jdField_c_of_type_Int == 1)
      {
        j = i;
        if (i > 8500.0D)
        {
          j = i;
          if (i < 13500.0D) {
            j = 10000;
          }
        }
      }
      i = j + paramInt1;
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "start = " + paramInt1 + ", end = " + paramInt2 + ", displayEnd = " + i);
      }
      this.jdField_c_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(paramInt1, false));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(QQStoryBGMusicUtils.a(i, true));
      return;
      i = j;
    }
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if (localQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo.jdField_d_of_type_Int = ((int)(localQQStoryMusicInfo.f * (paramInt3 / paramInt1)));
      localQQStoryMusicInfo.e = (localQQStoryMusicInfo.jdField_d_of_type_Int + this.jdField_a_of_type_Int);
      b(localQQStoryMusicInfo.jdField_d_of_type_Int, localQQStoryMusicInfo.e);
    }
  }
  
  protected void c()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.l();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    a();
    a(true);
  }
  
  public void d()
  {
    e();
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = new EditVideoMusicDialog.MusicPlayTask(this);
    this.jdField_a_of_type_JavaUtilTimer.schedule(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask, 0L, this.jdField_a_of_type_Long);
  }
  
  public void dismiss()
  {
    getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
    if ((this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp != null) && (this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a()))
    {
      com.tencent.mobileqq.utils.FileUtils.d(this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a());
      this.jdField_a_of_type_ComTencentBizQqstoryBaseDownloadDownloaderImp.a();
    }
    ((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).b(this.jdField_a_of_type_ComTencentBizQqstoryModelDataProvider$DataUpdateListener);
    e();
    a(true);
    super.dismiss();
  }
  
  protected void e()
  {
    if (this.jdField_a_of_type_JavaUtilTimer != null)
    {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
      this.jdField_a_of_type_JavaUtilTimer = null;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask.cancel();
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicEditVideoMusicDialog$MusicPlayTask = null;
    }
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(8);
  }
  
  public void f()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
    if ((localQQStoryMusicInfo != null) && (localQQStoryMusicInfo.jdField_b_of_type_Int == 3) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo) > 0) && (localQQStoryMusicInfo != null) && (!localQQStoryMusicInfo.equals(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a())))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(localQQStoryMusicInfo);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
      }
    }
  }
  
  public void onBackPressed()
  {
    g();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131371918: 
      g();
      VideoEditReport.a("0X80076DB");
      dismiss();
      return;
    case 2131371919: 
      VideoEditReport.a("0X80076DC");
      h();
      return;
    }
    h();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter != null)
    {
      paramView = (QQStoryMusicInfo)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.getItem(paramInt);
      if (paramView != null) {
        break label57;
      }
      if (QLog.isColorLevel()) {
        QLog.e("zivonchen", 2, "onItemClick error musicInfo = " + null);
      }
    }
    label57:
    do
    {
      do
      {
        return;
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a(paramView);
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.notifyDataSetChanged();
        if (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicMusicGridAdapter.a()) {
          break;
        }
        b();
        if (paramView.jdField_b_of_type_Int == 0)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(3);
          if (this.jdField_a_of_type_Boolean) {}
          for (paramAdapterView = "2";; paramAdapterView = "1")
          {
            StoryReportor.a("video_edit", "close_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
            VideoEditReport.a("0X80076D3");
            return;
          }
        }
        if (paramView.jdField_b_of_type_Int == 1)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
          this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
          if (this.jdField_a_of_type_Boolean) {}
          for (paramAdapterView = "2";; paramAdapterView = "1")
          {
            StoryReportor.a("video_edit", "clk_video_sound", 0, 0, new String[] { paramAdapterView, "", "", "" });
            VideoEditReport.a("0X80076D4");
            this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "2", true);
            return;
          }
        }
      } while (paramView.jdField_b_of_type_Int != 2);
      if (!NetworkUtil.g(BaseApplication.getContext()))
      {
        f();
        QQToast.a(BaseApplication.getContext(), 2131430033, 0).a();
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.c();
      this.jdField_b_of_type_Boolean = true;
      paramAdapterView = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramAdapterView != null) {
        paramAdapterView.a(true);
      }
      b();
      paramAdapterView = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a();
      if ((paramAdapterView instanceof BaseActivity)) {
        QQStoryBGMusicUtils.a((BaseActivity)paramAdapterView);
      }
      if (this.jdField_a_of_type_Boolean) {}
      for (paramAdapterView = "2";; paramAdapterView = "1")
      {
        StoryReportor.a("video_edit", "add_qqmusic", 0, 0, new String[] { paramAdapterView, "", "", "" });
        VideoEditReport.a("0X80076D5");
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(QQStoryMusicInfo.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicQQStoryMusicInfo);
      paramAdapterView = (EditVideoPlayerExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(EditVideoPlayerExport.class);
      if (paramAdapterView != null) {
        paramAdapterView.a(true);
      }
      b();
      if (paramView.jdField_b_of_type_Int != 4) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager == null);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoMusicBlessVoiceChangeManager.a(paramView);
    return;
    if (!TextUtils.isEmpty(paramView.jdField_d_of_type_JavaLangString))
    {
      this.jdField_a_of_type_AndroidViewView.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.jdField_b_of_type_JavaLangString);
      this.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a(paramView);
    a(paramView.jdField_d_of_type_JavaLangString);
    if (this.jdField_a_of_type_Boolean) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      StoryReportor.a("video_edit", "add_music", 0, 0, new String[] { paramAdapterView, "", "", "" });
      VideoEditReport.a("0X80076D8", "", "", paramView.jdField_b_of_type_JavaLangString, "");
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.a("608", "3", "1", true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.music.EditVideoMusicDialog
 * JD-Core Version:    0.7.0.1
 */