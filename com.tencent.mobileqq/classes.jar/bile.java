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

public class bile
  extends RecyclerView.Adapter<bili>
{
  private static boolean jdField_a_of_type_Boolean;
  private static List<String> b = new ArrayList();
  public biim a;
  private biju jdField_a_of_type_Biju;
  private bilh jdField_a_of_type_Bilh;
  private biqk jdField_a_of_type_Biqk;
  private biqn jdField_a_of_type_Biqn;
  private biqy jdField_a_of_type_Biqy = new bilg(this);
  private bivy jdField_a_of_type_Bivy;
  private INetEventHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler = new bilf(this);
  private AEBottomListScrollView jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView;
  private List<biqn> jdField_a_of_type_JavaUtilList;
  private Map<String, bili> jdField_a_of_type_JavaUtilMap;
  
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
  
  bile(biim parambiim, AEBottomListScrollView paramAEBottomListScrollView, biju parambiju)
  {
    this.jdField_a_of_type_Biim = parambiim;
    this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView = paramAEBottomListScrollView;
    this.jdField_a_of_type_Biju = parambiju;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Biqk = ((biqk)bjae.a(18));
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    AppNetConnInfo.registerNetChangeReceiver(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
    this.jdField_a_of_type_Bivy = ((bivy)biix.a(this.jdField_a_of_type_Biim).a(bivy.class));
  }
  
  private void a(biqt parambiqt)
  {
    if ((parambiqt != null) && (!parambiqt.d())) {
      this.jdField_a_of_type_Biqk.a(this.jdField_a_of_type_Biqk.a(), parambiqt.n, parambiqt, this.jdField_a_of_type_Biqy);
    }
  }
  
  private void c()
  {
    QLog.d("AEBottomListAdapter", 4, "###  preDownLoadResources");
    a(biks.c());
    a(biks.b());
    a(biks.a());
  }
  
  private void c(biqn parambiqn)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.3(this, parambiqn));
    this.jdField_a_of_type_Biim.a().getIntent().putExtra("widgetinfo", "camera^" + parambiqn.jdField_a_of_type_JavaLangString);
    if (this.jdField_a_of_type_Bivy.b())
    {
      this.jdField_a_of_type_Biju.a(this.jdField_a_of_type_Biqn);
      return;
    }
    bizq.d("AEBottomListAdapter", "selectMaterial---but current capture mode is not normal");
  }
  
  public bili a(ViewGroup paramViewGroup, int paramInt)
  {
    return new bili(LayoutInflater.from(paramViewGroup.getContext()).inflate(2131562597, paramViewGroup, false), this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView);
  }
  
  public biqn a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > paramInt)) {
      return (biqn)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(biqn.jdField_a_of_type_Biqn);
    biqn localbiqn = new biqn();
    localbiqn.jdField_a_of_type_JavaLangString = "stub_placeholder_material_id";
    int i = 0;
    while (i < 10)
    {
      this.jdField_a_of_type_JavaUtilList.add(localbiqn);
      i += 1;
    }
    this.jdField_a_of_type_Biqk.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
  }
  
  public void a(bilh parambilh)
  {
    this.jdField_a_of_type_Bilh = parambilh;
  }
  
  public void a(bili parambili)
  {
    super.onViewAttachedToWindow(parambili);
    if ((parambili.jdField_a_of_type_Biqn != null) && (!TextUtils.isEmpty(parambili.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.put(parambili.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString, parambili);
    }
  }
  
  public void a(bili parambili, int paramInt)
  {
    parambili.a((biqn)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public void a(biqn parambiqn)
  {
    if ((parambiqn != null) && (this.jdField_a_of_type_JavaUtilList.size() >= 1))
    {
      if (jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_JavaUtilList.remove(1);
        this.jdField_a_of_type_JavaUtilList.add(1, parambiqn);
        this.jdField_a_of_type_Biqk.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
        notifyDataSetChanged();
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.add(1, parambiqn);
    this.jdField_a_of_type_Biqk.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    notifyDataSetChanged();
    jdField_a_of_type_Boolean = true;
  }
  
  public void a(List<biqn> paramList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.add(biqn.jdField_a_of_type_Biqn);
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    if (!paramList.isEmpty())
    {
      paramList = new biqn();
      paramList.jdField_a_of_type_JavaLangString = "call_material_id";
      this.jdField_a_of_type_JavaUtilList.add(paramList);
    }
    this.jdField_a_of_type_Biqk.a(new LinkedList(this.jdField_a_of_type_JavaUtilList));
    jdField_a_of_type_Boolean = false;
    notifyDataSetChanged();
    c();
  }
  
  public void b()
  {
    AppNetConnInfo.unregisterNetEventHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetEventHandler);
  }
  
  public void b(bili parambili)
  {
    super.onViewDetachedFromWindow(parambili);
    if ((parambili.jdField_a_of_type_Biqn != null) && (!TextUtils.isEmpty(parambili.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_JavaUtilMap.remove(parambili.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(biqn parambiqn)
  {
    if (!FeatureManager.isBasicFeaturesFunctionReady())
    {
      bcpw.a(BaseApplicationImpl.getContext(), ajyc.a(2131716403), 0).a();
      ThreadManager.excute(new AEBottomListAdapter.2(this), 64, null, true);
    }
    label184:
    do
    {
      int i;
      do
      {
        return;
        if (parambiqn != null) {}
        for (;;)
        {
          this.jdField_a_of_type_Biqn = parambiqn;
          if ((this.jdField_a_of_type_Biqn == null) || ("stub_placeholder_material_id".equals(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString))) {
            break;
          }
          if ((!TextUtils.isEmpty(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_Biqn.a()) && (!this.jdField_a_of_type_Biqn.equals(biqn.jdField_a_of_type_Biqn))) {
            break label184;
          }
          this.jdField_a_of_type_Biqk.a(this.jdField_a_of_type_Biqn, false);
          QLog.d("AEBottomListAdapter", 4, "### [bottom list] select material none");
          if (this.jdField_a_of_type_Biju != null) {
            this.jdField_a_of_type_Biju.a(null);
          }
          this.jdField_a_of_type_Biim.a().getIntent().removeExtra("widgetinfo");
          return;
          i = this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.a();
          if (i >= getItemCount()) {
            break;
          }
          parambiqn = a(i);
        }
        if (!this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString.equals("call_material_id")) {
          break;
        }
      } while (this.jdField_a_of_type_Bilh == null);
      this.jdField_a_of_type_Bilh.a();
      return;
      if (this.jdField_a_of_type_Biqn.d)
      {
        c(this.jdField_a_of_type_Biqn);
        i = AEBeautyProviderView.a();
        this.jdField_a_of_type_Biju.a(i);
        i = AEBeautyProviderView.b();
        this.jdField_a_of_type_Biju.b(i);
        return;
      }
    } while ((this.jdField_a_of_type_Biqn.e) || (this.jdField_a_of_type_Biqn.d) || (TextUtils.isEmpty(this.jdField_a_of_type_Biqn.jdField_a_of_type_JavaLangString)) || (this.jdField_a_of_type_Biqk == null));
    if (!bbev.g(this.jdField_a_of_type_DovComQqImAeCameraUiBottomAEBottomListScrollView.getContext()))
    {
      bdid.a().a(ajyc.a(2131716398));
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.videostory.capture", 2, "start download template runnable");
    }
    this.jdField_a_of_type_Biqk.a(this.jdField_a_of_type_Biqk.a(), this.jdField_a_of_type_Biqn, this.jdField_a_of_type_Biqy);
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
 * Qualified Name:     bile
 * JD-Core Version:    0.7.0.1
 */