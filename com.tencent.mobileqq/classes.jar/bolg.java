import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bolg
  extends RecyclerView.Adapter<bolk>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> b;
  public static int c = 2130837642;
  private static int d;
  private static int e;
  public bofh a;
  private bojq jdField_a_of_type_Bojq;
  private bolj jdField_a_of_type_Bolj;
  private boqr jdField_a_of_type_Boqr;
  private boqu jdField_a_of_type_Boqu;
  private borc jdField_a_of_type_Borc = new boli(this);
  private bowk jdField_a_of_type_Bowk;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bolh(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<boqu> jdField_a_of_type_JavaUtilList;
  private Map<String, bolk> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    b = new ArrayList();
    d = 54;
    e = 54;
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    b.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    b.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  public bolg(bofh parambofh, AEBottomListScrollView paramAEBottomListScrollView, bojq parambojq)
  {
    this.jdField_a_of_type_Bofh = parambofh;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bojq = parambojq;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    if (born.a(parambofh))
    {
      d = 69;
      e = 53;
    }
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void a(boqx paramboqx)
  {
    if ((paramboqx != null) && (!paramboqx.d())) {
      this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqr.a(), paramboqx.p, paramboqx, this.jdField_a_of_type_Borc);
    }
  }
  
  private void c(boqu paramboqu)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, paramboqu));
    if (this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getVisibility() == 0)
    {
      if (this.jdField_a_of_type_Bowk.b())
      {
        this.jdField_a_of_type_Bojq.a(paramboqu);
        return;
      }
      bpam.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
      return;
    }
    bpam.d("AEBottomListAdapter", "selectMaterial---list not visible, not apply");
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bojq != null) && (this.jdField_a_of_type_Bojq.a != null) && (this.jdField_a_of_type_Bojq.a.a())) {
      this.jdField_a_of_type_Bojq.a.a(this.jdField_a_of_type_Boqu.b, this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public bolk a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = born.a(this.jdField_a_of_type_Bofh);
    if (bool) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558486, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563088, paramViewGroup, false)) {
      return new bolk(paramViewGroup, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, bool);
    }
  }
  
  public boqu a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (boqu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(boqu.jdField_a_of_type_Boqu);
    boqu localboqu = new boqu();
    localboqu.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localboqu);
      i += 1;
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bolj parambolj)
  {
    this.jdField_a_of_type_Bolj = parambolj;
  }
  
  public void a(bolk parambolk)
  {
    super.onViewAttachedToWindow(parambolk);
    if ((parambolk.jdField_a_of_type_Boqu != null) && (!TextUtils.isEmpty(parambolk.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambolk.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString, parambolk);
    }
  }
  
  public void a(bolk parambolk, int paramInt)
  {
    parambolk.a((boqu)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambolk, paramInt, getItemId(paramInt));
  }
  
  public void a(boqu paramboqu)
  {
    if ((paramboqu != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, paramboqu);
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, paramboqu);
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<boqu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(boqu.jdField_a_of_type_Boqu);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new boqu();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bokt.c());
    a(bokt.b());
    a(bokt.a());
  }
  
  public void b(bolk parambolk)
  {
    super.onViewDetachedFromWindow(parambolk);
    if ((parambolk.jdField_a_of_type_Boqu != null) && (!TextUtils.isEmpty(parambolk.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambolk.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(boqu paramboqu)
  {
    if (!bork.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), anzj.a(2131715184), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label198:
    do
    {
      int i;
      do
      {
        return;
        if (paramboqu != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Boqu = paramboqu;
          this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
          if ((this.jdField_a_of_type_Boqu == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Boqu.a()) && (!this.jdField_a_of_type_Boqu.equals(boqu.jdField_a_of_type_Boqu))) {
            break label198;
          }
          this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqu, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Bojq != null) {
            this.jdField_a_of_type_Bojq.a(null);
          }
          this.jdField_a_of_type_Bofh.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          paramboqu = a(i);
        }
        if (!this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Bolj == null);
      this.jdField_a_of_type_Bolj.a();
      return;
      if (this.jdField_a_of_type_Boqu.e)
      {
        c(this.jdField_a_of_type_Boqu);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Bojq.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Bojq.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Boqu.f) || (this.jdField_a_of_type_Boqu.e) || (TextUtils.isEmpty(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Boqr == null));
    if (!bhnv.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      bjuh.a().a(anzj.a(2131715179));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Boqr.a(this.jdField_a_of_type_Boqr.a(), this.jdField_a_of_type_Boqu, this.jdField_a_of_type_Borc);
  }
  
  public void c()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public int getItemCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    return super.getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bolg
 * JD-Core Version:    0.7.0.1
 */