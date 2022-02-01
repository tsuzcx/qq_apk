package com.tencent.aelight.camera.aioeditor.capture.view;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.LayoutInflater;
import com.tencent.aelight.camera.aioeditor.capture.QIMManager;
import com.tencent.aelight.camera.aioeditor.capture.data.IFaceSelectedListener;
import com.tencent.aelight.camera.aioeditor.capture.music.CaptureConfigUpdateObserver;
import com.tencent.aelight.camera.aioeditor.capture.paster.PasterDataManager;
import com.tencent.aelight.camera.aioeditor.capture.paster.QIMPasterConfigManager;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.FacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.LocationFacePackage;
import com.tencent.aelight.camera.aioeditor.doodle.ui.face.NormalFacePackage;
import com.tencent.aelight.camera.aioeditor.takevideo.EditVideoDoodle.DoodleFacePanelAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.layer.FaceLayer.FaceItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiItem;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.FaceListPage.FacePackagePageEventListener;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.AdapterObserver;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePagerAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.GestureHelper.ZoomItem;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.widget.bounce.BounceViewPager;
import com.tencent.mobileqq.widget.bounce.BounceViewPager.PageChangedObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(9)
public class StaticStickerProviderView
  extends ProviderView
  implements QIMSlidingTabView.IOnTabCheckListener, AdapterObserver, BounceViewPager.PageChangedObserver
{
  BounceViewPager a;
  FacePagerAdapter b;
  FacePanelBaseAdapter c;
  public ArrayList<String> d;
  CaptureConfigUpdateObserver e = new StaticStickerProviderView.2(this);
  private IFaceSelectedListener f;
  private int g = 0;
  
  public StaticStickerProviderView(Context paramContext)
  {
    super(paramContext);
  }
  
  private void a(PasterDataManager paramPasterDataManager, EditVideoDoodle.DoodleFacePanelAdapter paramDoodleFacePanelAdapter)
  {
    paramDoodleFacePanelAdapter.a(new ArrayList(paramPasterDataManager.f()));
  }
  
  public static void a(Collection<FacePackage> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab shufflePaster");
    }
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext())
    {
      FacePackage localFacePackage = (FacePackage)paramCollection.next();
      if (localFacePackage.g) {
        if ((localFacePackage instanceof NormalFacePackage)) {
          Collections.shuffle(((NormalFacePackage)localFacePackage).m);
        } else if ((localFacePackage instanceof LocationFacePackage)) {
          Collections.shuffle(((LocationFacePackage)localFacePackage).k);
        }
      }
    }
  }
  
  private void j()
  {
    ArrayList localArrayList1 = ((QIMPasterConfigManager)QIMManager.a(1)).a();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < localArrayList1.size())
    {
      if (((DoodleEmojiItem)localArrayList1.get(i)).hide != 1)
      {
        String str = ((DoodleEmojiItem)localArrayList1.get(i)).name;
        if (!localArrayList2.contains(str)) {
          localArrayList2.add(str);
        }
      }
      i += 1;
    }
    this.v.initTabItemsWithString(localArrayList2);
    this.d = localArrayList2;
  }
  
  private void m()
  {
    long l1 = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    double d1 = Runtime.getRuntime().maxMemory();
    Double.isNaN(d1);
    long l2 = (d1 * 0.8D);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("clearMemory ");
      boolean bool;
      if (l1 > l2) {
        bool = true;
      } else {
        bool = false;
      }
      localStringBuilder.append(bool);
      QLog.d("StaticStickerProviderView", 2, localStringBuilder.toString());
    }
    if ((l1 > l2) && (GlobalImageCache.a != null)) {
      GlobalImageCache.a.evictAll();
    }
  }
  
  public void a()
  {
    super.a();
    Object localObject = this.a;
    if (localObject != null) {
      ((BounceViewPager)localObject).b(this);
    }
    localObject = this.c;
    if (localObject != null) {
      ((FacePanelBaseAdapter)localObject).b(this);
    }
    localObject = ((PasterDataManager)QIMManager.a(4)).e();
    if (localObject != null) {
      ((EditVideoDoodle.DoodleFacePanelAdapter)localObject).b(this);
    }
    if (this.s != null) {
      this.s.unRegistObserver(this.e);
    }
  }
  
  public void a(int paramInt)
  {
    this.v.onTabChecked(paramInt);
    this.b.b(paramInt);
  }
  
  public void a(int paramInt1, float paramFloat, int paramInt2)
  {
    if (this.g == 1)
    {
      if (paramInt1 < this.a.getCurrentItem())
      {
        this.b.c(paramInt1);
        return;
      }
      if (paramInt1 == this.a.getCurrentItem()) {
        this.b.c(paramInt1 + 1);
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.w == null) {
      this.w = LayoutInflater.from(getContext()).inflate(2131627206, this, false);
    }
    a(this.w);
    this.a = ((BounceViewPager)findViewById(2131432744));
    this.b = new FacePagerAdapter(super.getContext());
    this.a.setAdapter(this.b);
    this.a.a(this);
    this.v.setTabCheckListener(this);
    j();
    paramBundle = (PasterDataManager)QIMManager.a(4);
    paramBundle.a();
    Object localObject = paramBundle.e();
    a(paramBundle, (EditVideoDoodle.DoodleFacePanelAdapter)localObject);
    setAdapter((FacePanelBaseAdapter)localObject);
    localObject = (Activity)getContext();
    setDownloadListener(new StaticStickerProviderView.1(this, (Activity)localObject));
    localObject = (DoodleLayout)((Activity)localObject).findViewById(2063991015);
    if (localObject == null)
    {
      AEQLog.d("StaticStickerProviderView", "doodleLayout is null.");
      return;
    }
    setOnFaceSelectedListener(((DoodleLayout)localObject).getFaceSelectedListener());
    this.s.registObserver(this.e);
    paramBundle.a(true, (Activity)getContext());
  }
  
  public void a(GestureHelper.ZoomItem paramZoomItem)
  {
    if (((paramZoomItem instanceof FaceLayer.FaceItem)) && (this.d != null))
    {
      Object localObject = (FaceLayer.FaceItem)paramZoomItem;
      paramZoomItem = ((FaceLayer.FaceItem)localObject).o;
      localObject = ((FaceLayer.FaceItem)localObject).n;
      int i = 0;
      while (i < this.d.size())
      {
        if (TextUtils.equals((String)this.d.get(i), (CharSequence)localObject))
        {
          onTabChecked(i);
          postDelayed(new StaticStickerProviderView.3(this, i, paramZoomItem), 200L);
        }
        i += 1;
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("selectPosition category=");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append(" name=");
        localStringBuilder.append(paramZoomItem);
        QLog.d("StaticStickerProviderView", 2, localStringBuilder.toString());
      }
    }
  }
  
  public void b()
  {
    super.b();
    IFaceSelectedListener localIFaceSelectedListener = this.f;
    if (localIFaceSelectedListener != null) {
      localIFaceSelectedListener.a();
    }
  }
  
  public void b(int paramInt)
  {
    this.g = paramInt;
    if (this.g == 0) {
      this.b.d(this.a.getCurrentItem());
    }
  }
  
  public void c()
  {
    super.c();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    this.b.notifyDataSetChanged();
  }
  
  public void c(int paramInt)
  {
    this.b.a(paramInt);
  }
  
  public void d()
  {
    super.d();
    this.a.removeAllViews();
    m();
  }
  
  public void e()
  {
    super.e();
    if (QLog.isColorLevel()) {
      QLog.d("StaticStickerProviderView", 2, "random tab paster onResume");
    }
    i();
  }
  
  public void g()
  {
    j();
    PasterDataManager localPasterDataManager = (PasterDataManager)QIMManager.a(4);
    EditVideoDoodle.DoodleFacePanelAdapter localDoodleFacePanelAdapter = localPasterDataManager.e();
    if (localDoodleFacePanelAdapter != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("StaticStickerProviderView", 2, "paster config updateData");
      }
      a(localPasterDataManager, localDoodleFacePanelAdapter);
      setAdapter(localDoodleFacePanelAdapter);
      h();
      this.v.onTabChecked(this.a.getCurrentItem());
    }
  }
  
  protected int getInflateLayout()
  {
    return 2131627206;
  }
  
  public void h()
  {
    this.b.a();
  }
  
  public void i()
  {
    if ((this.b != null) && (PasterDataManager.j.compareAndSet(true, false))) {
      g();
    }
  }
  
  public void onTabChecked(int paramInt)
  {
    this.a.setCurrentItem(paramInt);
    if (DoodleLayout.c) {
      localObject = "2";
    } else {
      localObject = "1";
    }
    DoodleLayout.a("change_face", 0, 0, new String[] { localObject });
    Object localObject = this.c;
    if (localObject != null)
    {
      localObject = ((FacePanelBaseAdapter)localObject).a(paramInt);
      if ((localObject != null) && ((localObject instanceof FacePackage)))
      {
        localObject = (FacePackage)localObject;
        VideoEditReport.a("0X80076C7", "", "", ((FacePackage)localObject).a, "");
        VideoEditReport.a("0X80075DC", ((FacePackage)localObject).a);
      }
    }
    if (paramInt == 1)
    {
      VideoEditReport.a("0X80076CC");
      VideoEditReport.b("0X80075E1");
    }
  }
  
  public void setAdapter(FacePanelBaseAdapter paramFacePanelBaseAdapter)
  {
    FacePanelBaseAdapter localFacePanelBaseAdapter = this.c;
    if (localFacePanelBaseAdapter != null)
    {
      localFacePanelBaseAdapter.b(this);
      this.c = null;
    }
    if (paramFacePanelBaseAdapter != null)
    {
      paramFacePanelBaseAdapter.b(this);
      this.c = paramFacePanelBaseAdapter;
      this.c.a(this);
      this.b.a(this.c);
    }
  }
  
  public void setCurrentItem(int paramInt)
  {
    this.a.setCurrentItem(paramInt);
  }
  
  public void setDownloadListener(FaceListPage.FacePackagePageEventListener paramFacePackagePageEventListener)
  {
    this.b.a(paramFacePackagePageEventListener);
  }
  
  public void setOnFaceSelectedListener(IFaceSelectedListener paramIFaceSelectedListener)
  {
    this.f = paramIFaceSelectedListener;
    this.b.a(paramIFaceSelectedListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.StaticStickerProviderView
 * JD-Core Version:    0.7.0.1
 */