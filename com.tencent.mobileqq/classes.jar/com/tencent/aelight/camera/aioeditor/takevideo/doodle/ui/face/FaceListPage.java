package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.InformationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.InformationFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.LocationFaceAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.NormalFaceAdapter;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.List;
import mqq.os.MqqHandler;

public class FaceListPage
  extends RelativeLayout
  implements View.OnClickListener
{
  public int a;
  public boolean b = false;
  private ImageView c;
  private TextView d;
  private ProgressBar e;
  private ListView f;
  private ViewGroup g;
  private ViewGroup h;
  private ViewGroup i;
  private ViewGroup j;
  private TextView k;
  private BaseFaceListAdapter l;
  private NormalFaceAdapter m;
  private LocationFaceAdapter n;
  private InformationFaceAdapter o;
  private FacePackage p;
  private FaceListPage.FacePackagePageEventListener q;
  private IFaceSelectedListener r;
  private int s;
  private Handler t = new Handler(Looper.getMainLooper());
  private boolean u;
  
  public FaceListPage(Context paramContext, IFaceSelectedListener paramIFaceSelectedListener, FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    super(paramContext);
    this.q = paramFacePackagePageEventListener;
    this.r = paramIFaceSelectedListener;
    f();
  }
  
  private void b(FacePackage paramFacePackage)
  {
    if ((paramFacePackage instanceof NormalFacePackage))
    {
      if (this.m == null) {
        this.m = new NormalFaceAdapter(super.getContext(), this);
      }
      this.l = this.m;
    }
    else if ((paramFacePackage instanceof LocationFacePackage))
    {
      if (this.n == null) {
        this.n = new LocationFaceAdapter(super.getContext(), this);
      }
      this.l = this.n;
    }
    else if ((paramFacePackage instanceof InformationFacePackage))
    {
      if (this.o == null) {
        this.o = new InformationFaceAdapter(super.getContext(), this);
      }
      this.l = this.o;
    }
    else
    {
      SLog.e("FaceListPage", "FacePackage is illegal.");
    }
    BaseFaceListAdapter localBaseFaceListAdapter = this.l;
    if (localBaseFaceListAdapter != null)
    {
      localBaseFaceListAdapter.d = this.a;
      localBaseFaceListAdapter.a(this.r);
      this.l.a(paramFacePackage);
      this.f.setAdapter(this.l);
    }
  }
  
  private boolean b()
  {
    return Looper.myLooper() == Looper.getMainLooper();
  }
  
  private void c()
  {
    SLog.b("FaceListPage", "FacePackage is InformationFacePackage");
    FacePackage localFacePackage = this.p;
    if (!(localFacePackage instanceof InformationFacePackage)) {
      return;
    }
    if (!((InformationFacePackage)localFacePackage).l.isEmpty())
    {
      this.g.setVisibility(4);
      this.h.setVisibility(4);
      this.f.setVisibility(0);
      this.l.notifyDataSetChanged();
      return;
    }
    this.g.setVisibility(4);
    this.f.setVisibility(4);
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setVisibility(4);
  }
  
  private void d()
  {
    SLog.b("FaceListPage", "FacePackage is LocationFacePackage");
    Object localObject = this.p;
    if (!(localObject instanceof LocationFacePackage)) {
      return;
    }
    localObject = (LocationFacePackage)localObject;
    if (!((LocationFacePackage)localObject).k.isEmpty())
    {
      this.g.setVisibility(4);
      this.h.setVisibility(4);
      this.f.setVisibility(0);
      this.l.notifyDataSetChanged();
      return;
    }
    if (((LocationFacePackage)localObject).l)
    {
      this.g.setVisibility(4);
      this.f.setVisibility(4);
      this.h.setVisibility(0);
      this.i.setVisibility(4);
      this.j.setVisibility(0);
      return;
    }
    this.g.setVisibility(4);
    this.f.setVisibility(4);
    this.h.setVisibility(0);
    this.i.setVisibility(0);
    this.j.setVisibility(4);
  }
  
  private void e()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("FacePackage is NormalFacePackage ");
    ((StringBuilder)localObject).append(this.p);
    SLog.b("FaceListPage", ((StringBuilder)localObject).toString());
    localObject = this.p;
    if (localObject == null) {
      return;
    }
    if (!(localObject instanceof NormalFacePackage)) {
      return;
    }
    NormalFacePackage localNormalFacePackage = (NormalFacePackage)localObject;
    boolean bool;
    if ((localNormalFacePackage.m != null) && (!localNormalFacePackage.m.isEmpty()))
    {
      SLog.b("FaceListPage", "FaceUriList is not empty,load bitmap directly.");
      bool = true;
    }
    else
    {
      bool = false;
    }
    if ((!bool) && (!TextUtils.isEmpty(localNormalFacePackage.l)))
    {
      SLog.b("FaceListPage", "FacePkgPath is not empty,try to load uriList from it.");
      localObject = localNormalFacePackage.e();
      if ((localObject != null) && (!((List)localObject).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
    }
    else
    {
      localObject = null;
    }
    ThreadManager.getUIHandler().post(new FaceListPage.2(this, localNormalFacePackage, (List)localObject, bool));
  }
  
  private void f()
  {
    this.s = AIOUtils.b(130.0F, super.getContext().getResources());
    LayoutInflater.from(super.getContext()).inflate(2131628034, this);
    this.c = ((ImageView)super.findViewById(2131432750));
    this.d = ((TextView)super.findViewById(2131432751));
    this.e = ((ProgressBar)super.findViewById(2131440726));
    this.f = ((ListView)super.findViewById(2131432734));
    this.g = ((RelativeLayout)super.findViewById(2131432728));
    this.h = ((RelativeLayout)super.findViewById(2131437685));
    this.i = ((LinearLayout)super.findViewById(2131437690));
    this.j = ((LinearLayout)super.findViewById(2131437681));
    this.k = ((TextView)findViewById(2131432086));
    this.k.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  public void a()
  {
    Object localObject = this.p;
    if (localObject == null)
    {
      SLog.b("FaceListPage", "onShow : FacePackage is null.");
      return;
    }
    if ("LocationFacePackage".equals(((FacePackage)localObject).c()))
    {
      localObject = (LocationFacePackage)this.p;
      if ((((LocationFacePackage)localObject).k.isEmpty()) && (!((LocationFacePackage)localObject).l) && (!this.u))
      {
        if (NetworkUtil.isNetworkAvailable(super.getContext())) {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "1" });
        } else {
          StoryReportor.a("video_shoot", "fail_poi", 0, 0, new String[] { "2" });
        }
        this.u = true;
      }
    }
    else if ("NormalFacePackage".equals(this.p.c()))
    {
      localObject = (NormalFacePackage)this.p;
      if ((NetworkUtil.isWifiEnabled(getContext())) && (this.q != null) && (!((NormalFacePackage)localObject).n) && (((NormalFacePackage)localObject).m.isEmpty()))
      {
        SLog.a("FaceListPage", "network is wifi. download automatically : %s .", localObject);
        this.q.a(((NormalFacePackage)localObject).a);
        StoryReportor.a("video_edit", "auto_down_sticker", 0, 0, new String[0]);
      }
    }
  }
  
  public void a(FacePackage paramFacePackage)
  {
    if (!b())
    {
      this.t.post(new FaceListPage.1(this, paramFacePackage));
      return;
    }
    if (paramFacePackage != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onChange,FacePkgInfo:");
      ((StringBuilder)localObject).append(paramFacePackage.toString());
      SLog.b("FaceListPage", ((StringBuilder)localObject).toString());
      localObject = this.p;
      if ((localObject == null) || (!((FacePackage)localObject).c().equals(paramFacePackage.c()))) {
        b(paramFacePackage);
      }
      this.p = paramFacePackage;
      if ("NormalFacePackage".equals(this.p.c()))
      {
        e();
        return;
      }
      if ("LocationFacePackage".equals(this.p.c()))
      {
        d();
        return;
      }
      if ("InformationFacePackage".equals(this.p.c())) {
        c();
      }
    }
    else
    {
      SLog.b("FaceListPage", "onChange, null.");
      this.p = null;
      this.l.a(null);
      this.f.setVisibility(4);
      this.g.setVisibility(4);
      this.h.setVisibility(4);
      this.d.setText("");
      this.e.setMax(1);
      this.e.setProgress(0);
    }
  }
  
  public void a(String paramString)
  {
    FacePackage localFacePackage = this.p;
    int i3 = 0;
    int i2 = i3;
    if (localFacePackage != null)
    {
      int i4 = localFacePackage.a();
      int i1 = 0;
      for (;;)
      {
        i2 = i3;
        if (i1 >= localFacePackage.d()) {
          break;
        }
        String str = localFacePackage.a(i1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectByName : ");
        localStringBuilder.append(paramString);
        localStringBuilder.append(str);
        SLog.b("FaceListPage", localStringBuilder.toString());
        if ((str != null) && (str.contains(paramString)))
        {
          i2 = i1 / i4;
          break;
        }
        i1 += 1;
      }
    }
    this.f.setSelection(i2);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.k)
    {
      if (this.q != null)
      {
        if (!((NormalFacePackage)this.p).n)
        {
          paramView = new StringBuilder();
          paramView.append("Download pkg:");
          paramView.append(this.p.a);
          SLog.b("FaceListPage", paramView.toString());
          this.q.a(this.p.a);
          this.k.setText(HardCodeUtil.a(2131902325));
          return;
        }
        this.q.b(this.p.a);
      }
    }
    else if ((paramView == this.i) && (this.q != null))
    {
      this.h.setVisibility(0);
      this.i.setVisibility(4);
      this.j.setVisibility(0);
      this.q.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage
 * JD-Core Version:    0.7.0.1
 */