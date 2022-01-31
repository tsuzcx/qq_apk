import android.app.Activity;
import android.content.Context;
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
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.5;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bkur
  extends RecyclerView.Adapter<bkux>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> b = new ArrayList();
  public bkpl a;
  private bkth jdField_a_of_type_Bkth;
  private bkuw jdField_a_of_type_Bkuw;
  private bkzy jdField_a_of_type_Bkzy;
  private blab jdField_a_of_type_Blab;
  private blan jdField_a_of_type_Blan = new bkuv(this);
  private blfq jdField_a_of_type_Blfq;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bkus(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<blab> jdField_a_of_type_JavaUtilList;
  private Map<String, bkux> jdField_a_of_type_JavaUtilMap;
  
  static
  {
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/yellow2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/green2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/purple2x2019083001.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/blue2x2019083001.png");
    b.add("https://qzonestyle.gtimg.cn/qzone/qzact/act/external/StorySticker/android/video_story_ptv_pendant_enter.png");
    b.add("https://qd.myapp.com/myapp/qqteam/QIM/fliters-QIM/other/none1.png");
    b.add("https://qd.myapp.com/myapp/qqteam/youqingzhiyuan/more.png");
  }
  
  bkur(bkpl parambkpl, AEBottomListScrollView paramAEBottomListScrollView, bkth parambkth)
  {
    this.jdField_a_of_type_Bkpl = parambkpl;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bkth = parambkth;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
  }
  
  private void a(blah paramblah)
  {
    if ((paramblah != null) && (!paramblah.d())) {
      this.jdField_a_of_type_Bkzy.a(this.jdField_a_of_type_Bkzy.a(), paramblah.o, paramblah, this.jdField_a_of_type_Blan);
    }
  }
  
  private void c(blab paramblab)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.5(this, paramblab));
    Intent localIntent = this.jdField_a_of_type_Bkpl.a().getIntent();
    localIntent.putExtra("widgetinfo", "camera^" + paramblab.jdField_a_of_type_JavaLangString);
    paramblab = paramblab.i;
    bljn.b("AEBottomListAdapter", "selectMaterial---塞拍同款名 takeSameName=" + paramblab);
    localIntent.putExtra("key_camera_material_name", paramblab);
    if (this.jdField_a_of_type_Blfq.b())
    {
      this.jdField_a_of_type_Bkth.a(this.jdField_a_of_type_Blab);
      return;
    }
    bljn.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public bkux a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkux(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562816, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public blab a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (blab)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(blab.jdField_a_of_type_Blab);
    blab localblab = new blab();
    localblab.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localblab);
      i += 1;
    }
    this.jdField_a_of_type_Bkzy.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bkuw parambkuw)
  {
    this.jdField_a_of_type_Bkuw = parambkuw;
  }
  
  public void a(bkux parambkux)
  {
    super.onViewAttachedToWindow(parambkux);
    if ((parambkux.jdField_a_of_type_Blab != null) && (!TextUtils.isEmpty(parambkux.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambkux.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString, parambkux);
    }
  }
  
  public void a(bkux parambkux, int paramInt)
  {
    parambkux.a((blab)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(blab paramblab)
  {
    if ((paramblab != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, paramblab);
        this.jdField_a_of_type_Bkzy.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, paramblab);
    this.jdField_a_of_type_Bkzy.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<blab> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(blab.jdField_a_of_type_Blab);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new blab();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Bkzy.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bkuf.c());
    a(bkuf.b());
    a(bkuf.a());
  }
  
  public void b(bkux parambkux)
  {
    super.onViewDetachedFromWindow(parambkux);
    if ((parambkux.jdField_a_of_type_Blab != null) && (!TextUtils.isEmpty(parambkux.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambkux.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(blab paramblab)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), alud.a(2131716798), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    for (;;)
    {
      return;
      if (paramblab != null) {}
      int i;
      for (;;)
      {
        this.jdField_a_of_type_Blab = paramblab;
        if ((this.jdField_a_of_type_Blab == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString))) {
          break;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Blab.a()) && (!this.jdField_a_of_type_Blab.equals(blab.jdField_a_of_type_Blab))) {
          break label184;
        }
        this.jdField_a_of_type_Bkzy.a(this.jdField_a_of_type_Blab, false);
        QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
        if (this.jdField_a_of_type_Bkth != null) {
          this.jdField_a_of_type_Bkth.a(null);
        }
        this.jdField_a_of_type_Bkpl.a().getIntent().removeExtra("widgetinfo");
        return;
        i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
        if (i >= getItemCount()) {
          break;
        }
        paramblab = a(i);
      }
      label184:
      if (this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString.equals("call_material_id"))
      {
        if (this.jdField_a_of_type_Bkuw != null) {
          this.jdField_a_of_type_Bkuw.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Blab.d)
        {
          c(this.jdField_a_of_type_Blab);
          i = AEBeautyProviderView.a();
          this.jdField_a_of_type_Bkth.a(i);
          i = AEBeautyProviderView.b();
          this.jdField_a_of_type_Bkth.b(i);
          return;
        }
        if ((!this.jdField_a_of_type_Blab.e) && (!this.jdField_a_of_type_Blab.d) && (!TextUtils.isEmpty(this.jdField_a_of_type_Blab.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bkzy != null))
        {
          if (!bdin.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            bflz.a().a(alud.a(2131716793));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.videostory.capture", 2, "start download template runnable");
          }
          if (!bdin.h(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            paramblab = bdgm.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), 230).setTitle(alud.a(2131710216)).setMessage(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131698629)).setPositiveButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131694953), new bkuu(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131690648), new bkut(this));
            if (paramblab == null) {
              continue;
            }
            try
            {
              if (!paramblab.isShowing())
              {
                paramblab.show();
                return;
              }
            }
            catch (Throwable paramblab)
            {
              paramblab.printStackTrace();
              return;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Bkzy.a(this.jdField_a_of_type_Bkzy.a(), this.jdField_a_of_type_Blab, this.jdField_a_of_type_Blan);
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
 * Qualified Name:     bkur
 * JD-Core Version:    0.7.0.1
 */