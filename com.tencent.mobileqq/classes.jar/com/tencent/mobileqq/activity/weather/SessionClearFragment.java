package com.tencent.mobileqq.activity.weather;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.aelight.camera.qqstory.api.IAECaptureContext;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.PublicFragmentActivityCallBackInterface;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider.Stub;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.message.messageclean.CleanMessageItemInfo;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.util.BinderWarpper;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class SessionClearFragment
  extends PublicBaseFragment
  implements PublicFragmentActivityCallBackInterface
{
  List<CleanMessageItemInfo> a;
  private RecyclerView b;
  private LinearLayoutManager c;
  private SessionClearFragment.SessionListAdapter d;
  private Button e;
  private TextView f;
  private Button g;
  private RelativeLayout h;
  private IAIOImageProvider i;
  private int j = 0;
  private INonMainProcAvatarLoader k;
  private INonMainProcAvatarLoader l;
  private INonMainProcAvatarLoader m;
  private PeakAppInterface n;
  private MessageCleanManager o;
  private SparseArray<URLDrawable> p = new SparseArray();
  private int q = 0;
  private QQProgressDialog r;
  private View s;
  private Bitmap t;
  private Activity u;
  private int v = 0;
  private LinearLayout w;
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getCoverDrawable():  getDrawable Exception, coverUrl=");
          localStringBuilder.append(paramString);
          QLog.e("SessionClearFragment", 2, localStringBuilder.toString(), localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private void a(int paramInt)
  {
    if (paramInt == 1) {
      this.e.setText(HardCodeUtil.a(2131911271));
    } else {
      this.e.setText(HardCodeUtil.a(2131911259));
    }
    this.j = paramInt;
  }
  
  private void a(Dialog paramDialog)
  {
    if (paramDialog != null)
    {
      Object localObject = this.u;
      if ((localObject != null) && (!((Activity)localObject).isFinishing())) {
        try
        {
          paramDialog.show();
          return;
        }
        catch (Throwable paramDialog)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("showDialogSafe exception: ");
            ((StringBuilder)localObject).append(paramDialog.getMessage());
            QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
  }
  
  private void a(View paramView)
  {
    this.b = ((RecyclerView)paramView.findViewById(2131445670));
    this.e = ((Button)paramView.findViewById(2131445510));
    this.j = 0;
    this.f = ((TextView)paramView.findViewById(2131446186));
    this.g = ((Button)paramView.findViewById(2131431708));
    this.h = ((RelativeLayout)paramView.findViewById(2131429680));
    this.c = new LinearLayoutManager(getBaseActivity());
    this.w = ((LinearLayout)paramView.findViewById(2131432490));
    this.b.setLayoutManager(this.c);
    this.d = new SessionClearFragment.SessionListAdapter(this, new ArrayList());
    this.b.setAdapter(this.d);
    this.e.setOnClickListener(new SessionClearFragment.5(this));
    this.g.setOnClickListener(new SessionClearFragment.6(this));
    paramView.findViewById(2131430817).setOnClickListener(new SessionClearFragment.7(this));
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, ImageView paramImageView, int paramInt3)
  {
    if (FileUtils.fileExistsAndNotEmpty(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString != null)
      {
        paramString = a(paramString.toString(), paramInt1, paramInt2);
        if ((paramString instanceof URLDrawable)) {
          this.p.put(paramInt3, (URLDrawable)paramString);
        }
        paramImageView.setImageDrawable(paramString);
        return;
      }
      QLog.d("SessionClearFragment", 2, "url  is null ");
    }
  }
  
  private void c()
  {
    this.n = ((PeakAppInterface)((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    if (this.i == null)
    {
      Object localObject = (BinderWarpper)this.u.getIntent().getParcelableExtra("extra.IMAGE_PROVIDER");
      if (localObject != null)
      {
        this.i = IAIOImageProvider.Stub.a(((BinderWarpper)localObject).a);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("IAIOImageProvider is ");
          ((StringBuilder)localObject).append(this.i);
          QLog.d("SessionClearFragment", 2, ((StringBuilder)localObject).toString());
        }
      }
      else
      {
        throw new IllegalArgumentException("can't find Binder in Intent..");
      }
    }
    this.n = ((PeakAppInterface)((IAECaptureContext)QRoute.api(IAECaptureContext.class)).getAppInterface());
    this.o = ((MessageCleanManager)this.n.getManager(4));
    this.o.a(new SessionClearFragment.1(this));
    this.o.a(this.i);
    this.k = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.u, 1);
    this.k.a();
    this.k.a(new SessionClearFragment.2(this));
    this.l = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.u, 4);
    this.l.a();
    this.l.a(new SessionClearFragment.3(this));
    this.m = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.u, 101);
    this.m.a();
    this.m.a(new SessionClearFragment.4(this));
    this.o.b();
    this.t = ImageUtil.k();
  }
  
  private void d()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i1 = 0;
    while (i1 < this.d.getItemCount())
    {
      if (this.d.a(i1).g) {
        localArrayList1.add(this.d.a(i1));
      } else {
        localArrayList2.add(this.d.a(i1));
      }
      i1 += 1;
    }
    if (localArrayList1.size() > 0)
    {
      this.o.a(localArrayList1);
      if (localArrayList2.size() == 0)
      {
        this.w.setVisibility(0);
      }
      else
      {
        this.d.a(localArrayList2);
        this.f.setVisibility(8);
        a(0);
      }
    }
    QQToast.makeText(this.u, 2, 2131888446, 0).show(getResources().getDimensionPixelSize(2131299920));
  }
  
  protected void a()
  {
    if (this.r == null) {
      this.r = new QQProgressDialog(this.u, getResources().getDimensionPixelSize(2131299920));
    }
    this.r.setCancelable(false);
    this.r.setCanceledOnTouchOutside(false);
    this.r.a(HardCodeUtil.a(2131911266));
    this.r.show();
    this.r.a(new SessionClearFragment.8(this));
  }
  
  public void a(List<CleanMessageItemInfo> paramList)
  {
    this.d.a(paramList);
  }
  
  protected void b()
  {
    QQProgressDialog localQQProgressDialog = this.r;
    if ((localQQProgressDialog != null) && (localQQProgressDialog.isShowing())) {
      this.r.dismiss();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.u = paramActivity;
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onAttach");
    }
  }
  
  public void onBackPressed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onBackPressed");
    }
    this.u.finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreate");
    }
    this.s = this.u.getWindow().getDecorView().findViewById(16908290);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle = (LinearLayout.LayoutParams)this.s.getLayoutParams();
      int i1 = ImmersiveUtils.getStatusBarHeight(getBaseActivity());
      if (paramBundle != null) {
        paramBundle.setMargins(0, i1, 0, 0);
      }
      this.s.setSystemUiVisibility(0);
    }
    c();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onCreateView");
    }
    paramLayoutInflater = paramLayoutInflater.inflate(2131629279, paramViewGroup, false);
    a(paramLayoutInflater);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onDestroy");
    }
    this.o.onDestroy();
    this.k.c();
    this.l.c();
    this.m.c();
    QQProgressDialog localQQProgressDialog = this.r;
    if (localQQProgressDialog != null) {
      localQQProgressDialog.dismiss();
    }
    this.u = null;
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SessionClearFragment", 2, "onNewIntent");
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.weather.SessionClearFragment
 * JD-Core Version:    0.7.0.1
 */