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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bncv
  extends RecyclerView.Adapter<bncz>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> jdField_b_of_type_JavaUtilList;
  public static int c = 2130837645;
  private static int d;
  private static int e;
  public bmxa a;
  private bnbg jdField_a_of_type_Bnbg;
  private bncy jdField_a_of_type_Bncy;
  private bnkb jdField_a_of_type_Bnkb;
  private bnke jdField_a_of_type_Bnke;
  private bnkq jdField_a_of_type_Bnkq = new bncx(this);
  private bnpz jdField_a_of_type_Bnpz;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bncw(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<bnke> jdField_a_of_type_JavaUtilList;
  private Map<String, bncz> jdField_a_of_type_JavaUtilMap;
  private boolean jdField_b_of_type_Boolean;
  
  static
  {
    jdField_b_of_type_JavaUtilList = new ArrayList();
    d = 54;
    e = 54;
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    jdField_b_of_type_JavaUtilList.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    jdField_b_of_type_JavaUtilList.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  public bncv(bmxa parambmxa, AEBottomListScrollView paramAEBottomListScrollView, bnbg parambnbg)
  {
    this.jdField_a_of_type_Bmxa = parambmxa;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bnbg = parambnbg;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bnkb = ((bnkb)bogd.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Bnpz = ((bnpz)bmxz.a(this.jdField_a_of_type_Bmxa).get(bnpz.class));
    if (bnlb.a(parambmxa))
    {
      d = 69;
      e = 53;
    }
  }
  
  public static void a(int paramInt)
  {
    c = paramInt;
  }
  
  private void a(bnkh parambnkh)
  {
    if ((parambnkh != null) && (!parambnkh.d())) {
      this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnkb.getApp(), parambnkh.p, parambnkh, this.jdField_a_of_type_Bnkq);
    }
  }
  
  private void c(bnke parambnke)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, parambnke));
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bnbg != null) && (this.jdField_a_of_type_Bnbg.a != null) && (this.jdField_a_of_type_Bnbg.a.a())) {
      this.jdField_a_of_type_Bnbg.a.a(this.jdField_a_of_type_Bnke.b, this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString);
    }
  }
  
  public bncz a(ViewGroup paramViewGroup, int paramInt)
  {
    boolean bool = bnlb.a(this.jdField_a_of_type_Bmxa);
    if (bool) {}
    for (paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131558488, paramViewGroup, false);; paramViewGroup = LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563046, paramViewGroup, false)) {
      return new bncz(paramViewGroup, this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView, bool);
    }
  }
  
  public bnke a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bnke)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bnke.jdField_a_of_type_Bnke);
    bnke localbnke = new bnke();
    localbnke.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbnke);
      i += 1;
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bncy parambncy)
  {
    this.jdField_a_of_type_Bncy = parambncy;
  }
  
  public void a(bncz parambncz)
  {
    super.onViewAttachedToWindow(parambncz);
    if ((parambncz.jdField_a_of_type_Bnke != null) && (!TextUtils.isEmpty(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString, parambncz);
    }
  }
  
  public void a(bncz parambncz, int paramInt)
  {
    parambncz.a((bnke)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambncz, paramInt, getItemId(paramInt));
  }
  
  public void a(bnke parambnke)
  {
    if ((parambnke != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambnke);
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambnke);
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<bnke> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bnke.jdField_a_of_type_Bnke);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new bnke();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bnck.c());
    a(bnck.b());
    a(bnck.a());
  }
  
  public void b(bncz parambncz)
  {
    super.onViewDetachedFromWindow(parambncz);
    if ((parambncz.jdField_a_of_type_Bnke != null) && (!TextUtils.isEmpty(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambncz.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(bnke parambnke)
  {
    if (!bnky.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), anvx.a(2131715766), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label206:
    do
    {
      int i;
      do
      {
        return;
        if (parambnke != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Bnke = parambnke;
          if (this.jdField_a_of_type_Bnke != null) {
            this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString);
          }
          if ((this.jdField_a_of_type_Bnke == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bnke.a()) && (!this.jdField_a_of_type_Bnke.equals(bnke.jdField_a_of_type_Bnke))) {
            break label206;
          }
          this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnke, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Bnbg != null) {
            this.jdField_a_of_type_Bnbg.a(null);
          }
          this.jdField_a_of_type_Bmxa.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          parambnke = a(i);
        }
        if (!this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Bncy == null);
      this.jdField_a_of_type_Bncy.a();
      return;
      if (this.jdField_a_of_type_Bnke.e)
      {
        c(this.jdField_a_of_type_Bnke);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Bnbg.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Bnbg.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Bnke.f) || (this.jdField_a_of_type_Bnke.e) || (TextUtils.isEmpty(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Bnkb == null));
    if (!NetworkUtil.isNetworkAvailable(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      bjkv.a().a(anvx.a(2131715761));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Bnkb.a(this.jdField_a_of_type_Bnkb.getApp(), this.jdField_a_of_type_Bnke, this.jdField_a_of_type_Bnkq);
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
 * Qualified Name:     bncv
 * JD-Core Version:    0.7.0.1
 */