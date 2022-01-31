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

public class bkqk
  extends RecyclerView.Adapter<bkqq>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> b = new ArrayList();
  public bkle a;
  private bkpa jdField_a_of_type_Bkpa;
  private bkqp jdField_a_of_type_Bkqp;
  private bkvr jdField_a_of_type_Bkvr;
  private bkvu jdField_a_of_type_Bkvu;
  private bkwg jdField_a_of_type_Bkwg = new bkqo(this);
  private blbj jdField_a_of_type_Blbj;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bkql(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<bkvu> jdField_a_of_type_JavaUtilList;
  private Map<String, bkqq> jdField_a_of_type_JavaUtilMap;
  
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
  
  bkqk(bkle parambkle, AEBottomListScrollView paramAEBottomListScrollView, bkpa parambkpa)
  {
    this.jdField_a_of_type_Bkle = parambkle;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bkpa = parambkpa;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bkvr = ((bkvr)blmf.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Blbj = ((blbj)bklq.a(this.jdField_a_of_type_Bkle).a(blbj.class));
  }
  
  private void a(bkwa parambkwa)
  {
    if ((parambkwa != null) && (!parambkwa.d())) {
      this.jdField_a_of_type_Bkvr.a(this.jdField_a_of_type_Bkvr.a(), parambkwa.o, parambkwa, this.jdField_a_of_type_Bkwg);
    }
  }
  
  private void c(bkvu parambkvu)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.5(this, parambkvu));
    Intent localIntent = this.jdField_a_of_type_Bkle.a().getIntent();
    localIntent.putExtra("widgetinfo", "camera^" + parambkvu.jdField_a_of_type_JavaLangString);
    parambkvu = parambkvu.i;
    blfg.b("AEBottomListAdapter", "selectMaterial---塞拍同款名 takeSameName=" + parambkvu);
    localIntent.putExtra("key_camera_material_name", parambkvu);
    if (this.jdField_a_of_type_Blbj.b())
    {
      this.jdField_a_of_type_Bkpa.a(this.jdField_a_of_type_Bkvu);
      return;
    }
    blfg.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public bkqq a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bkqq(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562798, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public bkvu a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bkvu)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bkvu.jdField_a_of_type_Bkvu);
    bkvu localbkvu = new bkvu();
    localbkvu.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbkvu);
      i += 1;
    }
    this.jdField_a_of_type_Bkvr.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bkqp parambkqp)
  {
    this.jdField_a_of_type_Bkqp = parambkqp;
  }
  
  public void a(bkqq parambkqq)
  {
    super.onViewAttachedToWindow(parambkqq);
    if ((parambkqq.jdField_a_of_type_Bkvu != null) && (!TextUtils.isEmpty(parambkqq.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambkqq.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString, parambkqq);
    }
  }
  
  public void a(bkqq parambkqq, int paramInt)
  {
    parambkqq.a((bkvu)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(bkvu parambkvu)
  {
    if ((parambkvu != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambkvu);
        this.jdField_a_of_type_Bkvr.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambkvu);
    this.jdField_a_of_type_Bkvr.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<bkvu> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bkvu.jdField_a_of_type_Bkvu);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new bkvu();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Bkvr.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bkpy.c());
    a(bkpy.b());
    a(bkpy.a());
  }
  
  public void b(bkqq parambkqq)
  {
    super.onViewDetachedFromWindow(parambkqq);
    if ((parambkqq.jdField_a_of_type_Bkvu != null) && (!TextUtils.isEmpty(parambkqq.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambkqq.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(bkvu parambkvu)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      QQToast.a(BaseApplicationImpl.getContext(), alpo.a(2131716786), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    for (;;)
    {
      return;
      if (parambkvu != null) {}
      int i;
      for (;;)
      {
        this.jdField_a_of_type_Bkvu = parambkvu;
        if ((this.jdField_a_of_type_Bkvu == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString))) {
          break;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bkvu.a()) && (!this.jdField_a_of_type_Bkvu.equals(bkvu.jdField_a_of_type_Bkvu))) {
          break label184;
        }
        this.jdField_a_of_type_Bkvr.a(this.jdField_a_of_type_Bkvu, false);
        QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
        if (this.jdField_a_of_type_Bkpa != null) {
          this.jdField_a_of_type_Bkpa.a(null);
        }
        this.jdField_a_of_type_Bkle.a().getIntent().removeExtra("widgetinfo");
        return;
        i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
        if (i >= getItemCount()) {
          break;
        }
        parambkvu = a(i);
      }
      label184:
      if (this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString.equals("call_material_id"))
      {
        if (this.jdField_a_of_type_Bkqp != null) {
          this.jdField_a_of_type_Bkqp.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bkvu.d)
        {
          c(this.jdField_a_of_type_Bkvu);
          i = AEBeautyProviderView.a();
          this.jdField_a_of_type_Bkpa.a(i);
          i = AEBeautyProviderView.b();
          this.jdField_a_of_type_Bkpa.b(i);
          return;
        }
        if ((!this.jdField_a_of_type_Bkvu.e) && (!this.jdField_a_of_type_Bkvu.d) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bkvu.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bkvr != null))
        {
          if (!bdee.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            bfhq.a().a(alpo.a(2131716781));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.videostory.capture", 2, "start download template runnable");
          }
          if (!bdee.h(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            parambkvu = bdcd.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), 230).setTitle(alpo.a(2131710204)).setMessage(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131698617)).setPositiveButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131694951), new bkqn(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131690648), new bkqm(this));
            if (parambkvu == null) {
              continue;
            }
            try
            {
              if (!parambkvu.isShowing())
              {
                parambkvu.show();
                return;
              }
            }
            catch (Throwable parambkvu)
            {
              parambkvu.printStackTrace();
              return;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Bkvr.a(this.jdField_a_of_type_Bkvr.a(), this.jdField_a_of_type_Bkvu, this.jdField_a_of_type_Bkwg);
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
 * Qualified Name:     bkqk
 * JD-Core Version:    0.7.0.1
 */