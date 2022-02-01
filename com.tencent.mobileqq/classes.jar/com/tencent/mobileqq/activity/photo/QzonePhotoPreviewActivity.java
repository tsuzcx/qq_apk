package com.tencent.mobileqq.activity.photo;

import NS_MOBILE_OPERATION.PicInfo;
import android.content.Intent;
import android.graphics.LinearGradient;
import android.graphics.Shader.TileMode;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qqlive.module.videoreport.inject.fragment.AndroidXFragmentCollector;
import com.tencent.widget.ListView;
import cooperation.qzone.widget.LocalPhotoLinearGradientView;
import java.util.ArrayList;
import java.util.HashMap;

public class QzonePhotoPreviewActivity
  extends PublicBaseFragment
{
  protected ListView a;
  protected LocalPhotoLinearGradientView b;
  protected TextView c;
  protected ArrayList<String> d;
  protected ArrayList<QzonePhotoPreviewActivity.PicInfoItem> e;
  protected HashMap<String, PicInfo> f;
  protected HashMap<String, LocalMediaInfo> g;
  protected QzonePhotoPreviewActivity.VerticalPictureAdapter h;
  int i = 0;
  private boolean j;
  
  private void a(View paramView)
  {
    this.b = ((LocalPhotoLinearGradientView)paramView.findViewById(2131444101));
    LinearGradient localLinearGradient = new LinearGradient(0.0F, ViewUtils.dip2px(79.0F), 0.0F, 0.0F, -14869219, 0, Shader.TileMode.CLAMP);
    this.b.setShader(localLinearGradient);
    this.a = ((ListView)paramView.findViewById(2131444102));
    this.c = ((TextView)paramView.findViewById(2131444100));
    this.a.setOnItemClickListener(new QzonePhotoPreviewActivity.1(this));
    this.c.setOnClickListener(new QzonePhotoPreviewActivity.2(this));
    this.h = new QzonePhotoPreviewActivity.VerticalPictureAdapter(this, getBaseActivity());
    this.a.setAdapter(this.h);
  }
  
  private void b()
  {
    this.d = c().getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    this.f = ((HashMap)c().getSerializableExtra("PhotoConst.PHOTO_INFOS"));
    this.g = ((HashMap)c().getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"));
    this.i = c().getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0);
    this.j = c().getBooleanExtra("PhotoConst.IS_FROM_QZONE_ALBUM", false);
    d();
  }
  
  private Intent c()
  {
    return getBaseActivity().getIntent();
  }
  
  private void d()
  {
    this.e = new ArrayList(1);
    int k = 0;
    while (k < this.d.size())
    {
      Object localObject1 = this.f;
      Object localObject2;
      double d1;
      double d2;
      if ((localObject1 != null) && (((HashMap)localObject1).size() > 0) && (this.f.containsKey(this.d.get(k))))
      {
        localObject1 = (PicInfo)this.f.get(this.d.get(k));
        if ((localObject1 != null) && (((PicInfo)localObject1).picwidth > 0))
        {
          localObject2 = this.e;
          String str = (String)this.d.get(k);
          d1 = ((PicInfo)localObject1).picheight;
          Double.isNaN(d1);
          d2 = ((PicInfo)localObject1).picwidth;
          Double.isNaN(d2);
          ((ArrayList)localObject2).add(new QzonePhotoPreviewActivity.PicInfoItem(this, str, (float)(d1 * 1.0D / d2)));
        }
      }
      localObject1 = this.g;
      if ((localObject1 != null) && (((HashMap)localObject1).containsKey(this.d.get(k))))
      {
        localObject1 = (LocalMediaInfo)this.g.get(this.d.get(k));
        int n;
        int m;
        if ((((LocalMediaInfo)localObject1).orientation != 90) && (((LocalMediaInfo)localObject1).orientation != 270))
        {
          n = ((LocalMediaInfo)localObject1).mediaHeight;
          m = ((LocalMediaInfo)localObject1).mediaWidth;
        }
        else
        {
          n = ((LocalMediaInfo)localObject1).mediaWidth;
          m = ((LocalMediaInfo)localObject1).mediaHeight;
        }
        localObject1 = this.e;
        localObject2 = (String)this.d.get(k);
        d1 = n;
        Double.isNaN(d1);
        d2 = m;
        Double.isNaN(d2);
        ((ArrayList)localObject1).add(new QzonePhotoPreviewActivity.PicInfoItem(this, (String)localObject2, (float)(d1 * 1.0D / d2)));
      }
      k += 1;
    }
  }
  
  public void a()
  {
    Intent localIntent = c();
    localIntent.setClass(getBaseActivity(), NewPhotoListActivity.class);
    startActivity(localIntent);
    getBaseActivity().finish();
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      if (this.j)
      {
        getBaseActivity().finish();
        AlbumUtil.anim(getBaseActivity(), true, false);
        return true;
      }
      a();
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = LayoutInflater.from(getBaseActivity()).inflate(2131628873, null);
    getBaseActivity().getWindow().addFlags(1024);
    AndroidXFragmentCollector.onAndroidXFragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    b();
    a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.QzonePhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */