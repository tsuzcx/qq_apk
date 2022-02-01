package com.tencent.aelight.camera.ae.camera.ui.dashboard;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.lifecycle.MutableLiveData;
import com.tencent.aelight.camera.ae.AEPath.CAMERA.CACHE;
import com.tencent.aelight.camera.ae.AEPituCameraUnit;
import com.tencent.aelight.camera.ae.part.VideoStoryBasePart;
import com.tencent.aelight.camera.ae.part.VideoStoryCapturePartManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.io.File;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.AppRuntime;

public class AEVideoStoryDashboardPart
  extends VideoStoryBasePart
{
  private AEPituCameraUnit a;
  private TextView b;
  private ScrollView c;
  private CheckBox d;
  private CheckBox e;
  private CheckBox f;
  private CheckBox g;
  private CheckBox h;
  private CheckBox i;
  private CheckBox j;
  private TextView k;
  private TextView l;
  private TextView m;
  private RecyclerView n;
  private AEVideoStoryDashboardPart.DashboardAdapter o;
  private RecyclerView p;
  private AEVideoStoryDashboardPart.DashboardAdapter q;
  private RecyclerView r;
  private AEVideoStoryDashboardPart.DashboardAdapter s;
  private RecyclerView t;
  private AEVideoStoryDashboardPart.DashboardAdapter u;
  private EditText v;
  private TextView w;
  private TextView x;
  private Pattern y;
  private Dialog z;
  
  public AEVideoStoryDashboardPart(Activity paramActivity, View paramView, VideoStoryCapturePartManager paramVideoStoryCapturePartManager)
  {
    super(paramActivity, paramView, paramVideoStoryCapturePartManager);
    this.a = ((AEPituCameraUnit)paramVideoStoryCapturePartManager.a(65537, new Object[0]));
  }
  
  private void a()
  {
    this.y = Pattern.compile("https?://.+\\.zip");
    Object localObject = (ClipboardManager)this.a.s().getSystemService("clipboard");
    if ((((ClipboardManager)localObject).hasPrimaryClip()) && (((ClipboardManager)localObject).getPrimaryClipDescription().hasMimeType("text/plain")))
    {
      localObject = ((ClipboardManager)localObject).getPrimaryClip().getItemAt(0).getText();
      localObject = this.y.matcher((CharSequence)localObject);
      if (((Matcher)localObject).find()) {
        this.v.setText(((Matcher)localObject).group(0));
      }
    }
    this.w.setOnClickListener(new AEVideoStoryDashboardPart.3(this));
    this.x.setOnClickListener(new AEVideoStoryDashboardPart.4(this));
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if ((this.mActivity != null) && (!this.mActivity.isFinishing()))
      {
        if (this.z == null)
        {
          this.z = new Dialog(this.mActivity, 2131953338);
          this.z.setCancelable(false);
          this.z.setCanceledOnTouchOutside(false);
          this.z.setContentView(2131625585);
        }
        this.z.show();
      }
    }
    else
    {
      Dialog localDialog = this.z;
      if ((localDialog != null) && (localDialog.isShowing())) {
        this.z.dismiss();
      }
    }
  }
  
  private void b()
  {
    this.d.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.6(this));
    this.e.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.7(this));
    this.f.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.8(this));
    this.g.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.9(this));
    this.h.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.10(this));
    this.i.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.11(this));
    this.j.setOnCheckedChangeListener(new AEVideoStoryDashboardPart.12(this));
  }
  
  private void b(String paramString)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.makeText(this.a.s(), "网络不可用", 0).show();
      return;
    }
    a(true);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("test");
    ((StringBuilder)localObject1).append(System.currentTimeMillis());
    Object localObject2 = ((StringBuilder)localObject1).toString();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AEPath.CAMERA.CACHE.a);
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append("test_material_zip");
    ((StringBuilder)localObject1).append(File.separator);
    ((StringBuilder)localObject1).append((String)localObject2);
    ((StringBuilder)localObject1).append(".zip");
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(AEPath.CAMERA.CACHE.a);
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append("test_materials");
    ((StringBuilder)localObject3).append(File.separator);
    ((StringBuilder)localObject3).append((String)localObject2);
    ((StringBuilder)localObject3).append(File.separator);
    localObject3 = ((StringBuilder)localObject3).toString();
    localObject2 = new HttpNetReq();
    ((HttpNetReq)localObject2).mCallback = new AEVideoStoryDashboardPart.5(this, paramString, (String)localObject1, (String)localObject3);
    ((HttpNetReq)localObject2).mReqUrl = paramString;
    ((HttpNetReq)localObject2).mHttpMethod = 0;
    ((HttpNetReq)localObject2).mOutPath = ((String)localObject1);
    ((HttpNetReq)localObject2).mContinuErrorLimit = NetworkUtil.getConnRetryTimes(NetworkCenter.getInstance().getNetType());
    ((HttpNetReq)localObject2).mExcuteTimeLimit = 60000L;
    try
    {
      ((IHttpEngineService)BaseApplicationImpl.getApplication().getRuntime().getRuntimeService(IHttpEngineService.class, "all")).sendReq((NetReq)localObject2);
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        localException.printStackTrace();
      }
    }
    ((HttpNetReq)localObject2).mCallback.onUpdateProgeress((NetReq)localObject2, 1L, 100L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startDownloadMaterial url: ");
    localStringBuilder.append(paramString);
    QLog.i("AEVideoStoryDashboardPart", 2, localStringBuilder.toString());
  }
  
  private void c()
  {
    this.o = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.q = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.s = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    this.u = new AEVideoStoryDashboardPart.DashboardAdapter(this.mActivity);
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.n.setLayoutManager(localLinearLayoutManager);
    this.n.setAdapter(this.o);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.p.setLayoutManager(localLinearLayoutManager);
    this.p.setAdapter(this.q);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.r.setLayoutManager(localLinearLayoutManager);
    this.r.setAdapter(this.s);
    localLinearLayoutManager = new LinearLayoutManager(this.mActivity, 1, false);
    this.t.setLayoutManager(localLinearLayoutManager);
    this.t.setAdapter(this.u);
  }
  
  private void d()
  {
    QIPCClientHelper.getInstance().callServer("AECameraGetInfoServer", "ACTION_GET_ENV_INFO", null, new AEVideoStoryDashboardPart.13(this));
  }
  
  private void e()
  {
    AEDashboardUtil.a().observe(this.a, new AEVideoStoryDashboardPart.14(this));
    AEDashboardUtil.b().observe(this.a, new AEVideoStoryDashboardPart.15(this));
  }
  
  public String a(String paramString)
  {
    File localFile = new File(paramString);
    if (localFile.isDirectory())
    {
      Object localObject = localFile.list();
      if (localObject != null)
      {
        int i1 = 0;
        while (i1 < localObject.length)
        {
          localFile = localObject[i1];
          if ((!TextUtils.isEmpty(localFile)) && (!localFile.startsWith(".")))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(localFile);
            return ((StringBuilder)localObject).toString();
          }
          i1 += 1;
        }
      }
    }
    return paramString;
  }
  
  protected void initView()
  {
    View localView = ((ViewStub)this.mRootView.findViewById(2063990792)).inflate();
    this.b = ((TextView)localView.findViewById(2063990811));
    this.c = ((ScrollView)localView.findViewById(2063991410));
    this.b.setOnClickListener(new AEVideoStoryDashboardPart.1(this));
    this.v = ((EditText)localView.findViewById(2063990809));
    this.w = ((TextView)localView.findViewById(2063990807));
    this.x = ((TextView)localView.findViewById(2063990808));
    this.k = ((TextView)localView.findViewById(2063990799));
    this.l = ((TextView)localView.findViewById(2063990804));
    this.m = ((TextView)localView.findViewById(2063990800));
    this.d = ((CheckBox)localView.findViewById(2063990795));
    this.e = ((CheckBox)localView.findViewById(2063990803));
    this.f = ((CheckBox)localView.findViewById(2063990810));
    this.g = ((CheckBox)localView.findViewById(2063990806));
    this.h = ((CheckBox)localView.findViewById(2063990797));
    this.h.setChecked(AEDashboardUtil.c());
    this.i = ((CheckBox)localView.findViewById(2063990798));
    this.i.setChecked(AEDashboardUtil.d());
    this.j = ((CheckBox)localView.findViewById(2063990801));
    this.n = ((RecyclerView)localView.findViewById(2063990794));
    this.p = ((RecyclerView)localView.findViewById(2063990802));
    this.r = ((RecyclerView)localView.findViewById(2063990793));
    this.t = ((RecyclerView)localView.findViewById(2063990805));
    a();
    b();
    c();
    d();
    this.m.setOnClickListener(new AEVideoStoryDashboardPart.2(this));
    e();
  }
  
  public void send(int paramInt, Object... paramVarArgs)
  {
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (paramInt == 720897)
    {
      localObject2 = (List)paramVarArgs[0];
      localObject1 = (List)paramVarArgs[1];
      paramVarArgs = new LinkedList();
      localObject2 = ((List)localObject2).iterator();
      AEVideoStoryDashboardPart.DashboardInfo localDashboardInfo;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AEDashboardUtil.BinaryInfo)((Iterator)localObject2).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = AEVideoStoryDashboardPart.MessageRenderUtil.a((AEDashboardUtil.BinaryInfo)localObject3);
        paramVarArgs.add(localDashboardInfo);
      }
      localObject2 = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (AEDashboardUtil.ABTestInfo)((Iterator)localObject1).next();
        localDashboardInfo = new AEVideoStoryDashboardPart.DashboardInfo(null);
        localDashboardInfo.a = ((AEDashboardUtil.ABTestInfo)localObject3).toString();
        ((List)localObject2).add(localDashboardInfo);
      }
      this.o.a(paramVarArgs);
      this.s.a((List)localObject2);
      return;
    }
    if ((paramInt == 720898) && (this.u != null))
    {
      localObject1 = AEDashboardUtil.a.h();
      paramVarArgs = new LinkedList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (String)((Iterator)localObject1).next();
        localObject3 = new AEVideoStoryDashboardPart.DashboardInfo(null);
        ((AEVideoStoryDashboardPart.DashboardInfo)localObject3).a = ((CharSequence)localObject2);
        paramVarArgs.add(localObject3);
      }
      this.u.a(paramVarArgs);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.ui.dashboard.AEVideoStoryDashboardPart
 * JD-Core Version:    0.7.0.1
 */