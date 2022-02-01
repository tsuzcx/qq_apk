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
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEMaterialPanel;
import dov.com.qq.im.ae.download.AEResUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class blpm
  extends RecyclerView.Adapter<blpq>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> b;
  public static int c = 2130837644;
  private static int d;
  private static int e;
  public bljy a;
  private blnv jdField_a_of_type_Blnv;
  private blpp jdField_a_of_type_Blpp;
  private bluy jdField_a_of_type_Bluy;
  private blvb jdField_a_of_type_Blvb;
  private blvj jdField_a_of_type_Blvj = new blpo(this);
  private bmap jdField_a_of_type_Bmap;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new blpn(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<blvb> jdField_a_of_type_JavaUtilList;
  private Map<String, blpq> jdField_a_of_type_JavaUtilMap;
  
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
  
  public blpm(bljy parambljy, AEBottomListScrollView paramAEBottomListScrollView, blnv paramblnv)
  {
    this.jdField_a_of_type_Bljy = parambljy;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Blnv = paramblnv;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bluy = ((bluy)bmql.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Bmap = ((bmap)blks.a(this.jdField_a_of_type_Bljy).get(bmap.class));
    if (blvr.a(parambljy))
    {
      d = 69;
      e = 53;
    }
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void a(blve paramblve)
  {
    if ((paramblve != null) && (!paramblve.d())) {
      this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Bluy.getApp(), paramblve.p, paramblve, this.jdField_a_of_type_Blvj);
    }
  }
  
  private void c(blvb paramblvb)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, paramblvb));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Blnv != null) && (this.jdField_a_of_type_Blnv.a != null) && (this.jdField_a_of_type_Blnv.a.a())) {
      this.jdField_a_of_type_Blnv.a.a(this.jdField_a_of_type_Blvb.b, this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString);
    }
  }
  
  public blpq a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = blvr.a(this.jdField_a_of_type_Bljy);
    if (bool) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558485, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562970, paramViewGroup, false)) {
      return new blpq(paramViewGroup, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, bool);
    }
  }
  
  public blvb a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (blvb)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(blvb.jdField_a_of_type_Blvb);
    blvb localblvb = new blvb();
    localblvb.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localblvb);
      i += 1;
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(blpp paramblpp)
  {
    this.jdField_a_of_type_Blpp = paramblpp;
  }
  
  public void a(blpq paramblpq)
  {
    super.onViewAttachedToWindow(paramblpq);
    if ((paramblpq.jdField_a_of_type_Blvb != null) && (!TextUtils.isEmpty(paramblpq.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(paramblpq.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString, paramblpq);
    }
  }
  
  public void a(blpq paramblpq, int paramInt)
  {
    paramblpq.a((blvb)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(paramblpq, paramInt, getItemId(paramInt));
  }
  
  public void a(blvb paramblvb)
  {
    if ((paramblvb != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, paramblvb);
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, paramblvb);
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<blvb> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(blvb.jdField_a_of_type_Blvb);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new blvb();
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
    a(bloz.c());
    a(bloz.b());
    a(bloz.a());
  }
  
  public void b(blpq paramblpq)
  {
    super.onViewDetachedFromWindow(paramblpq);
    if ((paramblpq.jdField_a_of_type_Blvb != null) && (!TextUtils.isEmpty(paramblpq.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(paramblpq.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(blvb paramblvb)
  {
    if (!AEResUtil.isAEBaseSoReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), amtj.a(2131715418), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label206:
    do
    {
      int i;
      do
      {
        return;
        if (paramblvb != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Blvb = paramblvb;
          if (this.jdField_a_of_type_Blvb != null) {
            this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_Blvb == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Blvb.a()) && (!this.jdField_a_of_type_Blvb.equals(blvb.jdField_a_of_type_Blvb))) {
            break label206;
          }
          this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Blvb, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Blnv != null) {
            this.jdField_a_of_type_Blnv.a(null);
          }
          this.jdField_a_of_type_Bljy.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          paramblvb = a(i);
        }
        if (!this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Blpp == null);
      this.jdField_a_of_type_Blpp.a();
      return;
      if (this.jdField_a_of_type_Blvb.e)
      {
        c(this.jdField_a_of_type_Blvb);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Blnv.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Blnv.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Blvb.f) || (this.jdField_a_of_type_Blvb.e) || (TextUtils.isEmpty(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bluy == null));
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      bhzt.a().a(amtj.a(2131715413));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Bluy.a(this.jdField_a_of_type_Bluy.getApp(), this.jdField_a_of_type_Blvb, this.jdField_a_of_type_Blvj);
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
 * Qualified Name:     blpm
 * JD-Core Version:    0.7.0.1
 */