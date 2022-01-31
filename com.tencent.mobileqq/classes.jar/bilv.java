import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView.Adapter;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.manager.FeatureManager;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.2;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.3;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListScrollView;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class bilv
  extends RecyclerView.Adapter<bilz>
{
  private static boolean jdField_a_of_type_Boolean;
  private static List<String> b = new ArrayList();
  public bijd a;
  private bikl jdField_a_of_type_Bikl;
  private bily jdField_a_of_type_Bily;
  private birb jdField_a_of_type_Birb;
  private bire jdField_a_of_type_Bire;
  private birp jdField_a_of_type_Birp = new bilx(this);
  private biwp jdField_a_of_type_Biwp;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bilw(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<bire> jdField_a_of_type_JavaUtilList;
  private Map<String, bilz> jdField_a_of_type_JavaUtilMap;
  
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
  
  bilv(bijd parambijd, AEBottomListScrollView paramAEBottomListScrollView, bikl parambikl)
  {
    this.jdField_a_of_type_Bijd = parambijd;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Bikl = parambikl;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Birb = ((birb)bjav.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Biwp = ((biwp)bijo.a(this.jdField_a_of_type_Bijd).a(biwp.class));
  }
  
  private void a(birk parambirk)
  {
    if ((parambirk != null) && (!parambirk.d())) {
      this.jdField_a_of_type_Birb.a(this.jdField_a_of_type_Birb.a(), parambirk.n, parambirk, this.jdField_a_of_type_Birp);
    }
  }
  
  private void c()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(bilj.c());
    a(bilj.b());
    a(bilj.a());
  }
  
  private void c(bire parambire)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, parambire));
    this.jdField_a_of_type_Bijd.a().getIntent().putExtra("widgetinfo", "camera^" + parambire.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Biwp.b())
    {
      this.jdField_a_of_type_Bikl.a(this.jdField_a_of_type_Bire);
      return;
    }
    bjah.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public bilz a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bilz(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562596, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public bire a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (bire)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bire.jdField_a_of_type_Bire);
    bire localbire = new bire();
    localbire.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbire);
      i += 1;
    }
    this.jdField_a_of_type_Birb.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bily parambily)
  {
    this.jdField_a_of_type_Bily = parambily;
  }
  
  public void a(bilz parambilz)
  {
    super.onViewAttachedToWindow(parambilz);
    if ((parambilz.jdField_a_of_type_Bire != null) && (!TextUtils.isEmpty(parambilz.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambilz.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString, parambilz);
    }
  }
  
  public void a(bilz parambilz, int paramInt)
  {
    parambilz.a((bire)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(bire parambire)
  {
    if ((parambire != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambire);
        this.jdField_a_of_type_Birb.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambire);
    this.jdField_a_of_type_Birb.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<bire> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(bire.jdField_a_of_type_Bire);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new bire();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Birb.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    c();
  }
  
  public void b()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void b(bilz parambilz)
  {
    super.onViewDetachedFromWindow(parambilz);
    if ((parambilz.jdField_a_of_type_Bire != null) && (!TextUtils.isEmpty(parambilz.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambilz.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(bire parambire)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      bcql.a(BaseApplicationImpl.getContext(), ajya.a(2131716414), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label184:
    do
    {
      int i;
      do
      {
        return;
        if (parambire != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Bire = parambire;
          if ((this.jdField_a_of_type_Bire == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Bire.a()) && (!this.jdField_a_of_type_Bire.equals(bire.jdField_a_of_type_Bire))) {
            break label184;
          }
          this.jdField_a_of_type_Birb.a(this.jdField_a_of_type_Bire, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Bikl != null) {
            this.jdField_a_of_type_Bikl.a(null);
          }
          this.jdField_a_of_type_Bijd.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          parambire = a(i);
        }
        if (!this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Bily == null);
      this.jdField_a_of_type_Bily.a();
      return;
      if (this.jdField_a_of_type_Bire.d)
      {
        c(this.jdField_a_of_type_Bire);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Bikl.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Bikl.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Bire.e) || (this.jdField_a_of_type_Bire.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Bire.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Birb == null));
    if (!bbfj.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      bdis.a().a(ajya.a(2131716409));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Birb.a(this.jdField_a_of_type_Birb.a(), this.jdField_a_of_type_Bire, this.jdField_a_of_type_Birp);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bilv
 * JD-Core Version:    0.7.0.1
 */