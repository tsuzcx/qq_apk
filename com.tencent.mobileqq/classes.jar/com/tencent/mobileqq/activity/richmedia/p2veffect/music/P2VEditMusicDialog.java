package com.tencent.mobileqq.activity.richmedia.p2veffect.music;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
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
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.music.EditVideoMusicCache;
import com.tencent.biz.qqstory.takevideo.music.MusicGridAdapter;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView;
import com.tencent.biz.qqstory.takevideo.music.MusicHorizontalSeekView.SeekListener;
import com.tencent.biz.qqstory.takevideo.music.QQStoryBGMusicUtils;
import com.tencent.biz.qqstory.takevideo.music.QQStoryMusicInfo;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

@TargetApi(11)
public class P2VEditMusicDialog
  extends Dialog
  implements View.OnClickListener, AdapterView.OnItemClickListener, DownloadProgressListener, CmdTaskManger.CommandCallback<GetMusicConfigRequest, GetMusicConfigResponse>, MusicHorizontalSeekView.SeekListener
{
  private static final String D = "P2VEditMusicDialog";
  public P2VEditMusicDialog.IP2VMusicEditListener A;
  protected Handler B = new P2VEditMusicDialog.2(this);
  protected volatile int C = 0;
  private EditVideoMusicCache E;
  private DataProvider.DataUpdateListener<AddressDataProvider.AddressInfo> F = new P2VEditMusicDialog.4(this);
  protected GridView a = null;
  protected MusicGridAdapter b = null;
  protected MusicHorizontalSeekView c = null;
  protected TextView d = null;
  protected TextView e = null;
  protected View f = null;
  protected TextView g = null;
  protected TextView h = null;
  protected TextView i = null;
  protected TextView j = null;
  protected ProgressBar k = null;
  protected View l = null;
  protected View m = null;
  protected DownloaderImp n = null;
  protected Timer o = null;
  protected P2VEditMusicDialog.MusicPlayTask p = null;
  ArrayList<QQStoryMusicInfo> q = new ArrayList();
  protected HashMap<String, String> r = new HashMap();
  protected HashMap<String, Long> s = new HashMap();
  protected int t = 0;
  protected int u = 0;
  protected long v = 1000L;
  protected long w = 0L;
  protected QQStoryMusicInfo x;
  protected int y;
  protected boolean z;
  
  public P2VEditMusicDialog(Context paramContext, P2VEditMusicDialog.IP2VMusicEditListener paramIP2VMusicEditListener, int paramInt, boolean paramBoolean)
  {
    super(paramContext, 2131952026);
    super.requestWindowFeature(1);
    this.t = paramInt;
    this.z = paramBoolean;
    this.A = paramIP2VMusicEditListener;
    this.E = new EditVideoMusicCache(paramContext, new P2VEditMusicDialog.1(this), this.B);
    a(paramContext);
    paramContext = super.getWindow().getAttributes();
    paramContext.width = -1;
    paramContext.height = -1;
    paramContext.windowAnimations = 2131952049;
    super.getWindow().setBackgroundDrawable(new ColorDrawable());
  }
  
  public static void a(Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("url", String.format("https://ti.qq.com/music/index.html?_wv=5&_bid=2831&device_id=%s&client_ip=%s&bustype=%s", new Object[] { DeviceInfoUtil.b(), "", Integer.valueOf(5) }));
    localIntent.putExtra("finish_animation_up_down", true);
    paramActivity.startActivityForResult(localIntent, 1000);
    paramActivity.overridePendingTransition(2130771996, 0);
  }
  
  private void i()
  {
    this.A.a(this.x);
    QQStoryMusicInfo localQQStoryMusicInfo = this.x;
    if (localQQStoryMusicInfo != null)
    {
      if (localQQStoryMusicInfo.k == 1)
      {
        this.B.sendEmptyMessage(6);
        return;
      }
      if (this.x.k == 0)
      {
        this.B.sendEmptyMessage(3);
        return;
      }
      if (!TextUtils.isEmpty(this.x.m))
      {
        this.B.sendEmptyMessage(11);
        return;
      }
      this.B.sendEmptyMessage(6);
      this.A.a(QQStoryMusicInfo.b);
      return;
    }
    this.B.sendEmptyMessage(6);
    this.A.a(QQStoryMusicInfo.b);
  }
  
  private void j()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.A.a();
    if ((localQQStoryMusicInfo != null) && (this.x != null) && ((localQQStoryMusicInfo.k == 3) || (localQQStoryMusicInfo.k == 2))) {
      localQQStoryMusicInfo.d.equals(this.x.d);
    }
    dismiss();
  }
  
  private void k()
  {
    this.A.e();
  }
  
  public void a()
  {
    g();
    d();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    int i1 = (int)(this.g.getPaint().measureText("00:00") / 2.0F);
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt1 - i1);
    this.g.setLayoutParams(localLayoutParams);
    localLayoutParams = (LinearLayout.LayoutParams)this.h.getLayoutParams();
    localLayoutParams.leftMargin = (paramInt2 - i1 * 2);
    this.h.setLayoutParams(localLayoutParams);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    b();
    b(paramInt1, paramInt2, paramInt3);
  }
  
  public void a(Context paramContext)
  {
    View localView = LayoutInflater.from(paramContext).inflate(2131628097, null);
    super.setContentView(localView);
    int i1 = this.t;
    if (i1 < 5000) {
      this.v = (i1 / 6);
    } else {
      this.v = 1000L;
    }
    this.k = ((ProgressBar)localView.findViewById(2131439042));
    this.l = localView.findViewById(2131439024);
    this.c = ((MusicHorizontalSeekView)localView.findViewById(2131439028));
    this.c.setOnSeekListener(this);
    this.d = ((TextView)localView.findViewById(2131439029));
    this.g = ((TextView)super.findViewById(2131445501));
    this.h = ((TextView)super.findViewById(2131445500));
    this.i = ((TextView)super.findViewById(2131439038));
    this.j = ((TextView)super.findViewById(2131439039));
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
    this.e = ((TextView)localView.findViewById(2131432493));
    this.e.setText("");
    this.f = localView.findViewById(2131445548);
    if (this.A.g())
    {
      this.a = ((GridView)localView.findViewById(2131439025));
      this.a.setNumColumns(-1);
      this.a.setSelector(new ColorDrawable(0));
      if (Build.VERSION.SDK_INT >= 9) {
        this.a.setOverScrollMode(2);
      }
      this.a.setOnItemClickListener(this);
      this.m = localView.findViewById(2131431986);
      this.m.setOnClickListener(this);
      this.b = new MusicGridAdapter(paramContext, this.a, this.A.h() ^ true, true);
      this.a.setAdapter(this.b);
      this.b.a(null);
    }
    else
    {
      localView.findViewById(2131431894).getLayoutParams().height = AIOUtils.b(138.0F, paramContext.getResources());
      localView.findViewById(2131439030).setVisibility(8);
    }
    if (this.A.a() != null)
    {
      this.x = new QQStoryMusicInfo();
      this.x.a(this.A.a());
    }
    else
    {
      this.x = this.A.a();
    }
    this.q = QQStoryMusicInfo.a(getContext());
    this.B.sendEmptyMessage(1);
    if (NetworkUtil.isNetSupport(getContext()))
    {
      this.w = System.currentTimeMillis();
      paramContext = new GetMusicConfigRequest();
      CmdTaskManger.a().a(paramContext, this);
      return;
    }
    this.B.sendEmptyMessage(1);
    QQToast.makeText(getContext(), HardCodeUtil.a(2131905682), 0).show();
  }
  
  public void a(GetMusicConfigRequest paramGetMusicConfigRequest, GetMusicConfigResponse paramGetMusicConfigResponse, ErrorMessage paramErrorMessage)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onCmdRespond = ");
      localStringBuilder.append(System.currentTimeMillis() - this.w);
      localStringBuilder.append(", errorMsg = ");
      if (paramErrorMessage == null) {
        paramGetMusicConfigRequest = "null";
      } else {
        paramGetMusicConfigRequest = paramErrorMessage.getErrorMessage();
      }
      localStringBuilder.append(paramGetMusicConfigRequest);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
    }
    StoryReportor.a("edit_video", "music_list_time", 0, 0, new String[] { String.valueOf(System.currentTimeMillis() - this.w), "", "", "" });
    if ((paramErrorMessage != null) && (paramErrorMessage.isFail()))
    {
      paramGetMusicConfigRequest = this.B.obtainMessage(7);
      paramGetMusicConfigResponse = new StringBuilder();
      paramGetMusicConfigResponse.append("onCmdRespond error = ");
      paramGetMusicConfigResponse.append(paramErrorMessage.getErrorMessage());
      paramGetMusicConfigRequest.obj = paramGetMusicConfigResponse.toString();
      this.B.sendMessage(paramGetMusicConfigRequest);
      StoryReportor.a("edit_video", "music_list_failed", 0, 0, new String[] { "", "", "", "" });
      return;
    }
    paramGetMusicConfigResponse = paramGetMusicConfigResponse.a;
    int i2 = paramGetMusicConfigResponse.music_config.size();
    paramGetMusicConfigRequest = new ArrayList(i2);
    if (i2 > 0)
    {
      int i1 = 0;
      while (i1 < i2)
      {
        paramGetMusicConfigRequest.add(new QQStoryMusicInfo((qqstory_struct.MusicConfigInfo)paramGetMusicConfigResponse.music_config.get(i1)));
        i1 += 1;
      }
      if (QLog.isColorLevel())
      {
        paramGetMusicConfigResponse = new StringBuffer();
        paramErrorMessage = new StringBuilder();
        paramErrorMessage.append("GetMusicConfigResponse size = ");
        paramErrorMessage.append(i2);
        paramGetMusicConfigResponse.append(paramErrorMessage.toString());
        i1 = 0;
        while (i1 < i2)
        {
          paramErrorMessage = (QQStoryMusicInfo)paramGetMusicConfigRequest.get(i1);
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(", ");
          ((StringBuilder)localObject).append(i1);
          ((StringBuilder)localObject).append(": title = ");
          ((StringBuilder)localObject).append(paramErrorMessage.e);
          ((StringBuilder)localObject).append(", audioUrl = ");
          ((StringBuilder)localObject).append(paramErrorMessage.g);
          paramGetMusicConfigResponse.append(((StringBuilder)localObject).toString());
          i1 += 1;
        }
        QLog.d(D, 2, paramGetMusicConfigResponse.toString());
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.e(D, 2, "onCmdRespond data is NULL!!!!!");
    }
    StoryReportor.a("edit_video", "music_list_count", 0, 0, new String[] { String.valueOf(i2), "", "", "" });
    this.q = paramGetMusicConfigRequest;
    QQStoryMusicInfo.a(getContext(), paramGetMusicConfigRequest);
    this.B.sendEmptyMessage(1);
  }
  
  protected void a(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    String str = paramQQStoryMusicInfo.g;
    Object localObject = paramQQStoryMusicInfo.m;
    if ((TextUtils.isEmpty(str)) && (TextUtils.isEmpty((CharSequence)localObject)))
    {
      QLog.e(D, 1, "playCacheMusicOrDownload - musicUrl、localPath both null ？！");
      return;
    }
    paramQQStoryMusicInfo = (QQStoryMusicInfo)localObject;
    if (!com.tencent.biz.qqstory.utils.FileUtils.i((String)localObject))
    {
      localObject = (String)this.r.get(str);
      paramQQStoryMusicInfo = (QQStoryMusicInfo)localObject;
      if (!com.tencent.biz.qqstory.utils.FileUtils.i((String)localObject)) {
        paramQQStoryMusicInfo = QQStoryBGMusicUtils.a(str);
      }
    }
    if (com.tencent.biz.qqstory.utils.FileUtils.i(paramQQStoryMusicInfo))
    {
      localObject = this.n;
      if ((localObject != null) && (((DownloaderImp)localObject).c()))
      {
        com.tencent.mobileqq.utils.FileUtils.deleteFile(this.n.b());
        this.n.a();
      }
      if (this.A.a() != null)
      {
        this.A.a(paramQQStoryMusicInfo);
        this.B.sendEmptyMessage(2);
      }
      else
      {
        QLog.e(D, 1, "getCurFragmentMusic - urMusic is null");
      }
      localObject = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exists audio_url = ");
      localStringBuilder.append(str);
      localStringBuilder.append(", path = ");
      localStringBuilder.append(paramQQStoryMusicInfo);
      QLog.d((String)localObject, 2, localStringBuilder.toString());
      return;
    }
    if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
    {
      g();
      QQToast.makeText(BaseApplication.getContext(), 2131892951, 0).show();
      return;
    }
    this.s.put(str, Long.valueOf(System.currentTimeMillis()));
    this.r.put(str, paramQQStoryMusicInfo);
    paramQQStoryMusicInfo = this.n;
    if ((paramQQStoryMusicInfo != null) && (paramQQStoryMusicInfo.c()))
    {
      com.tencent.mobileqq.utils.FileUtils.deleteFile(this.n.b());
      this.n.a();
    }
    ThreadManager.post(new P2VEditMusicDialog.3(this, str), 5, null, true);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject1 = QQStoryBGMusicUtils.a(paramString);
    Object localObject2;
    if (paramInt == 0)
    {
      this.C = 0;
      if (QLog.isColorLevel())
      {
        localObject2 = D;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDownloadFinish() url = ");
        localStringBuilder.append(paramString);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      if (this.r == null) {
        this.r = new HashMap();
      }
      this.r.put(paramString, localObject1);
      localObject2 = this.A.a();
      if ((localObject2 != null) && (paramString.equals(((QQStoryMusicInfo)localObject2).g)))
      {
        this.A.a((String)localObject1);
        this.B.sendEmptyMessage(2);
        getContext().getSharedPreferences("VideoMusicCache", 0).edit().putString(((QQStoryMusicInfo)localObject2).d, (String)localObject1).apply();
      }
      StoryReportor.a("edit_video", "music_download_success", 0, 0, new String[] { "", "", "", "" });
    }
    else
    {
      StoryReportor.a("edit_video", "music_download_failed", 0, 0, new String[] { String.valueOf(paramInt), "", "", "" });
      VideoEditReport.a("0X80076D9");
    }
    if (QLog.isColorLevel())
    {
      long l1 = ((Long)this.s.get(paramString)).longValue();
      localObject2 = new StringBuffer("onDownloadFinish errCode = ");
      ((StringBuffer)localObject2).append(paramInt);
      ((StringBuffer)localObject2).append(", name = ");
      ((StringBuffer)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.l(paramString));
      ((StringBuffer)localObject2).append(", downloadTime = ");
      ((StringBuffer)localObject2).append(System.currentTimeMillis() - l1);
      ((StringBuffer)localObject2).append(", fileSize = ");
      ((StringBuffer)localObject2).append(com.tencent.biz.qqstory.utils.FileUtils.a((String)localObject1));
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(", url = ");
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuffer)localObject2).append(((StringBuilder)localObject1).toString());
      QLog.d(D, 2, ((StringBuffer)localObject2).toString());
    }
  }
  
  public void a(String paramString, long paramLong1, long paramLong2)
  {
    float f1 = (float)paramLong1 / (float)paramLong2;
    if (f1 >= this.C * 0.05F)
    {
      this.C += 1;
      paramString = this.B.obtainMessage(9);
      paramString.arg1 = ((int)(100.0F * f1));
      this.B.sendMessage(paramString);
      if (QLog.isColorLevel())
      {
        paramString = D;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onProgress() mIndex = ");
        localStringBuilder.append(this.C);
        localStringBuilder.append(", progress = ");
        localStringBuilder.append(f1);
        localStringBuilder.append(", cur = ");
        localStringBuilder.append(paramLong1);
        localStringBuilder.append(", size = ");
        localStringBuilder.append(paramLong2);
        QLog.d(paramString, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      String str = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onDownloadStart() url = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(", dstPath = ");
      localStringBuilder.append(paramString2);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.C = 0;
    paramString1 = this.B.obtainMessage(9);
    paramString1.arg1 = 0;
    this.B.sendMessage(paramString1);
  }
  
  protected void b()
  {
    e();
    this.A.c();
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    int i2 = (paramInt2 - paramInt1) / 1000 * 1000;
    int i1 = i2;
    if (i2 < 1000) {
      i1 = 1000;
    }
    i2 = i1;
    if (this.y == 1)
    {
      double d1 = i1;
      i2 = i1;
      if (d1 > 8500.0D)
      {
        i2 = i1;
        if (d1 < 13500.0D) {
          i2 = 10000;
        }
      }
    }
    i1 = i2 + paramInt1;
    if (QLog.isColorLevel())
    {
      String str = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("start = ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(", end = ");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append(", displayEnd = ");
      localStringBuilder.append(i1);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    this.g.setText(TimeFormatterUtils.a(paramInt1, false));
    this.h.setText(TimeFormatterUtils.a(i1, true));
  }
  
  public void b(int paramInt1, int paramInt2, int paramInt3)
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.A.a();
    if (localQQStoryMusicInfo != null)
    {
      localQQStoryMusicInfo.n = ((int)(localQQStoryMusicInfo.p * (paramInt3 / paramInt1)));
      localQQStoryMusicInfo.o = (localQQStoryMusicInfo.n + this.t);
      b(localQQStoryMusicInfo.n, localQQStoryMusicInfo.o);
    }
  }
  
  public void b(QQStoryMusicInfo paramQQStoryMusicInfo)
  {
    if ((!TextUtils.isEmpty(paramQQStoryMusicInfo.g)) || (!TextUtils.isEmpty(paramQQStoryMusicInfo.m)))
    {
      this.f.setVisibility(0);
      this.e.setVisibility(8);
      this.d.setText(paramQQStoryMusicInfo.e);
      this.l.setVisibility(8);
    }
    this.A.a(paramQQStoryMusicInfo);
    a(paramQQStoryMusicInfo);
    VideoEditReport.a("0X80076D6");
  }
  
  protected void c()
  {
    this.A.d();
  }
  
  public void c(int paramInt1, int paramInt2, int paramInt3)
  {
    b(paramInt1, paramInt2, paramInt3);
    c();
  }
  
  public void d()
  {
    e();
    this.o = new Timer();
    this.p = new P2VEditMusicDialog.MusicPlayTask(this);
    this.o.schedule(this.p, 0L, this.v);
  }
  
  public void dismiss()
  {
    this.E.a();
    DownloaderImp localDownloaderImp = this.n;
    if ((localDownloaderImp != null) && (localDownloaderImp.c()))
    {
      com.tencent.mobileqq.utils.FileUtils.deleteFile(this.n.b());
      this.n.a();
    }
    ((AddressDataProvider)((DataProviderManager)SuperManager.a(20)).a(1)).b(this.F);
    e();
    c();
    super.dismiss();
  }
  
  protected void e()
  {
    Object localObject = this.o;
    if (localObject != null)
    {
      ((Timer)localObject).cancel();
      this.o = null;
    }
    localObject = this.p;
    if (localObject != null)
    {
      ((P2VEditMusicDialog.MusicPlayTask)localObject).cancel();
      this.p = null;
    }
    this.u = -1;
    this.B.sendEmptyMessage(8);
  }
  
  protected int f()
  {
    int i2 = this.t;
    int i1 = i2;
    if (i2 < 5000) {
      i1 = 5000;
    }
    return i1;
  }
  
  protected void g()
  {
    QQStoryMusicInfo localQQStoryMusicInfo = this.A.a();
    if ((localQQStoryMusicInfo != null) && (localQQStoryMusicInfo.k == 3))
    {
      MusicGridAdapter localMusicGridAdapter = this.b;
      if ((localMusicGridAdapter != null) && (localMusicGridAdapter.b(localQQStoryMusicInfo) > 0) && (!localQQStoryMusicInfo.equals(this.b.c())))
      {
        this.b.a(localQQStoryMusicInfo);
        this.b.notifyDataSetChanged();
        if (QLog.isColorLevel()) {
          QLog.d(D, 2, "checkButtonState 按钮错位!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        }
      }
    }
  }
  
  public void onBackPressed()
  {
    i();
    super.onBackPressed();
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131439039: 
      j();
      break;
    case 2131439038: 
      i();
      dismiss();
      break;
    case 2131431986: 
      j();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (QQStoryMusicInfo)((MusicGridAdapter)localObject).getItem(paramInt);
      if (localObject == null)
      {
        if (QLog.isColorLevel())
        {
          localObject = D;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onItemClick error musicInfo = ");
          localStringBuilder.append(null);
          QLog.e((String)localObject, 2, localStringBuilder.toString());
        }
      }
      else
      {
        this.b.a((QQStoryMusicInfo)localObject);
        this.b.notifyDataSetChanged();
        if (paramInt < this.b.b())
        {
          b();
          if (((QQStoryMusicInfo)localObject).k == 0)
          {
            this.A.a((QQStoryMusicInfo)localObject);
            this.B.sendEmptyMessage(3);
          }
          else if (((QQStoryMusicInfo)localObject).k == 1)
          {
            this.A.a((QQStoryMusicInfo)localObject);
            this.B.sendEmptyMessage(6);
          }
          else if (((QQStoryMusicInfo)localObject).k == 2)
          {
            if (!NetworkUtil.isNetworkAvailable(BaseApplication.getContext()))
            {
              g();
              QQToast.makeText(BaseApplication.getContext(), 2131892951, 0).show();
            }
            else
            {
              this.A.b();
              if ((!this.A.f()) && ((getContext() instanceof ContextThemeWrapper)) && ((((ContextThemeWrapper)getContext()).getBaseContext() instanceof Activity))) {
                a((Activity)((ContextThemeWrapper)getContext()).getBaseContext());
              }
            }
          }
        }
        else
        {
          b();
          if (!TextUtils.isEmpty(((QQStoryMusicInfo)localObject).g))
          {
            this.f.setVisibility(0);
            this.e.setVisibility(8);
            this.d.setText(((QQStoryMusicInfo)localObject).e);
            this.l.setVisibility(8);
          }
          this.A.a((QQStoryMusicInfo)localObject);
          a((QQStoryMusicInfo)localObject);
          StoryReportor.a("video_edit", "add_music", 0, 0, new String[] { "1", "", "", "" });
        }
      }
    }
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.p2veffect.music.P2VEditMusicDialog
 * JD-Core Version:    0.7.0.1
 */