import android.app.Activity;
import android.arch.lifecycle.ViewModelProvider;
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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
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

public class bnjw
  extends RecyclerView.Adapter<bnkc>
{
  public static int a;
  private static boolean jdField_a_of_type_Boolean;
  public static int b;
  private static List<String> b = new ArrayList();
  public bndy a;
  private bnii jdField_a_of_type_Bnii;
  private bnkb jdField_a_of_type_Bnkb;
  private bnpc jdField_a_of_type_Bnpc;
  private bnpf jdField_a_of_type_Bnpf;
  private bnpq jdField_a_of_type_Bnpq = new bnka(this);
  private bnuy jdField_a_of_type_Bnuy;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bnjx(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<bnpf> jdField_a_of_type_JavaUtilList;
  private Map<String, bnkc> jdField_a_of_type_JavaUtilMap;
  
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
  
  bnjw(bndy parambndy, AEBottomListScrollView paramAEBottomListScrollView, bnii parambnii)
  {
    this.jdField_a_of_type_Bndy = parambndy;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bnii = parambnii;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Bnpc = ((bnpc)bojv.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Bnuy = ((bnuy)bner.a(this.jdField_a_of_type_Bndy).get(bnuy.class));
  }
  
  private void a(bnpl parambnpl)
  {
    if ((parambnpl != null) && (!parambnpl.d())) {
      this.jdField_a_of_type_Bnpc.a(this.jdField_a_of_type_Bnpc.a(), parambnpl.p, parambnpl, this.jdField_a_of_type_Bnpq);
    }
  }
  
  private void c(bnpf parambnpf)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.5(this, parambnpf));
    if (this.jdField_a_of_type_Bnuy.b())
    {
      this.jdField_a_of_type_Bnii.a(this.jdField_a_of_type_Bnpf);
      return;
    }
    bnzb.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public bnkc a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bnkc(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131563053, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public bnpf a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bnpf)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bnpf.jdField_a_of_type_Bnpf);
    bnpf localbnpf = new bnpf();
    localbnpf.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbnpf);
      i += 1;
    }
    this.jdField_a_of_type_Bnpc.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bnkb parambnkb)
  {
    this.jdField_a_of_type_Bnkb = parambnkb;
  }
  
  public void a(bnkc parambnkc)
  {
    super.onViewAttachedToWindow(parambnkc);
    if ((parambnkc.jdField_a_of_type_Bnpf != null) && (!TextUtils.isEmpty(parambnkc.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambnkc.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString, parambnkc);
    }
  }
  
  public void a(bnkc parambnkc, int paramInt)
  {
    parambnkc.a((bnpf)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    EventCollector.getInstance().onRecyclerBindViewHolder(parambnkc, paramInt, getItemId(paramInt));
  }
  
  public void a(bnpf parambnpf)
  {
    if ((parambnpf != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambnpf);
        this.jdField_a_of_type_Bnpc.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambnpf);
    this.jdField_a_of_type_Bnpc.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<bnpf> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bnpf.jdField_a_of_type_Bnpf);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new bnpf();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Bnpc.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    b();
  }
  
  public void b()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bnjj.c());
    a(bnjj.b());
    a(bnjj.a());
  }
  
  public void b(bnkc parambnkc)
  {
    super.onViewDetachedFromWindow(parambnkc);
    if ((parambnkc.jdField_a_of_type_Bnpf != null) && (!TextUtils.isEmpty(parambnkc.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambnkc.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(bnpf parambnpf)
  {
    if (!bnpy.a())
    {
      QQToast.a(BaseApplicationImpl.getContext(), anni.a(2131715075), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    for (;;)
    {
      return;
      if (parambnpf != null) {}
      int i;
      for (;;)
      {
        this.jdField_a_of_type_Bnpf = parambnpf;
        if ((this.jdField_a_of_type_Bnpf == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString))) {
          break;
        }
        if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bnpf.a()) && (!this.jdField_a_of_type_Bnpf.equals(bnpf.jdField_a_of_type_Bnpf))) {
          break label184;
        }
        this.jdField_a_of_type_Bnpc.a(this.jdField_a_of_type_Bnpf, false);
        QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
        if (this.jdField_a_of_type_Bnii != null) {
          this.jdField_a_of_type_Bnii.a(null);
        }
        this.jdField_a_of_type_Bndy.a().getIntent().removeExtra("widgetinfo");
        return;
        i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
        if (i >= getItemCount()) {
          break;
        }
        parambnpf = a(i);
      }
      label184:
      if (this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString.equals("call_material_id"))
      {
        if (this.jdField_a_of_type_Bnkb != null) {
          this.jdField_a_of_type_Bnkb.a();
        }
      }
      else
      {
        if (this.jdField_a_of_type_Bnpf.e)
        {
          c(this.jdField_a_of_type_Bnpf);
          i = AEBeautyProviderView.a();
          this.jdField_a_of_type_Bnii.a(i);
          i = AEBeautyProviderView.b();
          this.jdField_a_of_type_Bnii.b(i);
          return;
        }
        if ((!this.jdField_a_of_type_Bnpf.f) && (!this.jdField_a_of_type_Bnpf.e) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bnpf.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Bnpc != null))
        {
          if (!bgnt.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            biti.a().a(anni.a(2131715070));
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.videostory.capture", 2, "start download template runnable");
          }
          if (!bgnt.h(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
          {
            parambnpf = bglp.a(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), 230).setTitle(anni.a(2131708592)).setMessage(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131697516)).setPositiveButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131694081), new bnjz(this)).setNegativeButton(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext().getString(2131690582), new bnjy(this));
            if (parambnpf == null) {
              continue;
            }
            try
            {
              if (!parambnpf.isShowing())
              {
                parambnpf.show();
                return;
              }
            }
            catch (Throwable parambnpf)
            {
              parambnpf.printStackTrace();
              return;
            }
          }
        }
      }
    }
    this.jdField_a_of_type_Bnpc.a(this.jdField_a_of_type_Bnpc.a(), this.jdField_a_of_type_Bnpf, this.jdField_a_of_type_Bnpq);
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
 * Qualified Name:     bnjw
 * JD-Core Version:    0.7.0.1
 */