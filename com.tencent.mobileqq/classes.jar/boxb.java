import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModelProvider;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.sdk.LaunchParam;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import dov.com.qq.im.ae.mode.AECaptureMode;
import dov.com.qq.im.ae.play.AEPlayShowPageView;
import dov.com.qq.im.ae.play.AEPlayShowPart.1;
import dov.com.qq.im.ae.play.AEPlayShowPart.4;
import dov.com.qq.im.ae.play.AEPlayShowPart.5;
import dov.com.qq.im.ae.play.AEPlayShowPart.6;
import dov.com.qq.im.ae.play.AEPlayShowTabView;
import dov.com.qq.im.ae.play.AETemplateInfoFragment;
import dov.com.qq.im.ae.play.PlayViewPagerAdapter;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class boxb
  extends bowm
  implements bczs
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private bofh jdField_a_of_type_Bofh;
  private boqr jdField_a_of_type_Boqr;
  private bowk jdField_a_of_type_Bowk;
  private bowy jdField_a_of_type_Bowy;
  private AEPlayShowTabView jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView;
  private PlayViewPagerAdapter jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private View c;
  
  public boxb(Activity paramActivity, ViewStub paramViewStub, bown parambown)
  {
    super(paramActivity, paramViewStub, parambown);
    this.jdField_a_of_type_Bofh = ((bofh)parambown.a(65537, new Object[0]));
    this.jdField_a_of_type_Bowy = ((bowy)bplq.a().c(19));
    this.jdField_a_of_type_Boqr = ((boqr)bplq.a().c(18));
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.1(this));
    this.jdField_a_of_type_Bowy.a(this, 1);
    this.jdField_a_of_type_Boqr.a(this, 116);
    b();
    a(null);
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter != null) && (this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a() != null)) {
      return this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a().getScrollY();
    }
    return 0;
  }
  
  private boqq a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        boqq localboqq = (boqq)((Iterator)localObject).next();
        if ((localboqq != null) && (paramString != null) && (paramString.equals(localboqq.b))) {
          return localboqq;
        }
      }
    }
    return null;
  }
  
  private String a()
  {
    ArrayList localArrayList = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.a();
    int i = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.a();
    if ((localArrayList != null) && (i < localArrayList.size())) {
      return ((bpwm)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
    if (localObject != null)
    {
      boqq localboqq;
      boqu localboqu;
      do
      {
        localObject = ((List)localObject).iterator();
        Iterator localIterator;
        while (!localIterator.hasNext())
        {
          do
          {
            if (!((Iterator)localObject).hasNext()) {
              break;
            }
            localboqq = (boqq)((Iterator)localObject).next();
          } while ((localboqq == null) || (localboqq.jdField_a_of_type_JavaUtilList == null));
          localIterator = localboqq.jdField_a_of_type_JavaUtilList.iterator();
        }
        localboqu = (boqu)localIterator.next();
      } while ((localboqu == null) || (paramString == null) || (!paramString.equals(localboqu.jdField_a_of_type_JavaLangString)));
      return localboqq.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private ArrayList<bpwm> a(List<boqq> paramList)
  {
    if (paramList == null) {
      paramList = null;
    }
    for (;;)
    {
      return paramList;
      try
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          boqq localboqq = (boqq)paramList.next();
          bpwm localbpwm = new bpwm();
          localbpwm.jdField_a_of_type_JavaLangString = localboqq.b;
          localArrayList.add(localbpwm);
        }
        paramList = localArrayList;
      }
      finally {}
    }
  }
  
  @NonNull
  private List<boqq> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.jdField_a_of_type_Bowy.a();
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.a(paramInt);
  }
  
  private void a(@Nullable String paramString)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "preLoadWebView, url=" + paramString);
    }
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidAppActivity, PreloadWebService.class);
    if (!TextUtils.isEmpty(paramString)) {
      localIntent.putExtra("url", paramString);
    }
    try
    {
      this.jdField_a_of_type_AndroidAppActivity.startService(localIntent);
      return;
    }
    catch (Throwable paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("AEPlayShowPart", 2, "preLoadWebView, error=", paramString);
    }
  }
  
  private void a(String paramString, int paramInt)
  {
    ThreadManager.getUIHandler().post(new AEPlayShowPart.6(this, paramString, paramInt));
  }
  
  private void a(String paramString1, String paramString2)
  {
    paramString1 = a(paramString1);
    if (paramString1 != null)
    {
      paramString1 = paramString1.jdField_a_of_type_JavaUtilList;
      if (paramString1 != null) {
        break label20;
      }
    }
    label20:
    label88:
    for (;;)
    {
      return;
      int i = 0;
      for (;;)
      {
        if (i >= paramString1.size()) {
          break label88;
        }
        boqu localboqu = (boqu)paramString1.get(i);
        if ((localboqu != null) && (paramString2 != null) && (paramString2.equals(localboqu.jdField_a_of_type_JavaLangString)))
        {
          paramString1 = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
          if (paramString1 == null) {
            break;
          }
          paramString1.a(i);
          return;
        }
        i += 1;
      }
    }
  }
  
  private void a(List<boqq> paramList, List<bpwm> paramList1)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (CollectionUtils.isEmpty(paramList1)))
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup == null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewStub.inflate());
        this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131379653);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new boxg(this));
      }
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(0);
    }
    while ((this.jdField_b_of_type_AndroidViewViewGroup == null) || (this.jdField_b_of_type_AndroidViewViewGroup.getVisibility() != 0)) {
      return;
    }
    this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
  }
  
  private String b(String paramString)
  {
    if (this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter != null)
    {
      Object localObject1 = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
      if (localObject1 != null)
      {
        boqq localboqq;
        boqu localboqu;
        do
        {
          localObject1 = ((List)localObject1).iterator();
          Object localObject2;
          while (!((Iterator)localObject2).hasNext())
          {
            do
            {
              do
              {
                if (!((Iterator)localObject1).hasNext()) {
                  break;
                }
                localboqq = (boqq)((Iterator)localObject1).next();
              } while (localboqq == null);
              localObject2 = localboqq.jdField_a_of_type_JavaUtilList;
            } while (localObject2 == null);
            localObject2 = ((List)localObject2).iterator();
          }
          localboqu = (boqu)((Iterator)localObject2).next();
        } while ((localboqu == null) || (paramString == null) || (!paramString.equals(localboqu.jdField_a_of_type_JavaLangString)));
        return localboqq.b;
      }
    }
    return "";
  }
  
  private void b()
  {
    this.jdField_a_of_type_Bowk = ((bowk)bofz.a(this.jdField_a_of_type_Bofh).get(bowk.class));
    this.jdField_a_of_type_Bowk.a.observe(this.jdField_a_of_type_Bofh, new boxe(this));
    boqg.b().observe(this.jdField_a_of_type_Bofh, new boxf(this));
  }
  
  private String c(String paramString)
  {
    if ((this.jdField_a_of_type_Bofh != null) && (this.jdField_a_of_type_Bofh.a() != null) && (this.jdField_a_of_type_Bofh.a().getIntent() != null)) {
      return this.jdField_a_of_type_Bofh.a().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private void e()
  {
    Object localObject1 = a();
    a(null);
    Object localObject2 = a((List)localObject1);
    if ((localObject2 != null) && (((ArrayList)localObject2).size() > 0))
    {
      QLog.d("AEPlayShowPart", 2, "tabDataList size: " + ((ArrayList)localObject2).size());
      if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
        this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
      }
      this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setVisibility(0);
      this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(0);
      String str1 = a();
      int i = a();
      this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.a((ArrayList)localObject2);
      this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a((List)localObject1);
      this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.notifyDataSetChanged();
      localObject1 = c("KEY_CURRENT_SELECT_ID");
      Object localObject3 = c("KEY_CURRENT_TYPE");
      localObject2 = c("KEY_CURRENT_TAB");
      String str2 = b((String)localObject1);
      boqq localboqq = a(str2);
      localObject3 = new StringBuilder().append("chooseId: ").append((String)localObject1).append(" typeId: ").append((String)localObject3).append(" posTabName: ").append(str2).append(" isMaterial null: ");
      if (localboqq == null) {}
      for (boolean bool = true;; bool = false)
      {
        bpam.a("AEPlayShowPart", bool);
        if ((localboqq == null) || (!AECaptureMode.PLAY.name.equals(localObject2))) {
          break;
        }
        a(655364, new Object[] { str2, localObject1 });
        return;
      }
      a(str1, i);
      return;
    }
    QLog.d("AEPlayShowPart", 2, "no data.");
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setVisibility(8);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setVisibility(8);
    a((List)localObject1, (List)localObject2);
  }
  
  private void f()
  {
    if (this.c == null)
    {
      this.c = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559572, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.c);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(13);
      this.c.setLayoutParams(localLayoutParams);
    }
    this.c.setVisibility(0);
  }
  
  private void h()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  @TargetApi(12)
  private void i()
  {
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewViewGroup, "alpha", new float[] { 0.0F, 1.0F }));
    localAnimatorSet.setDuration(200L).start();
  }
  
  protected void a() {}
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    int i = 0;
    Object localObject1;
    Object localObject2;
    if (paramInt == 655361) {
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof boqu)))
      {
        paramVarArgs = (boqu)paramVarArgs[0];
        if (paramVarArgs.equals(bowt.a))
        {
          localObject1 = bofc.b + File.separator + paramVarArgs.jdField_a_of_type_JavaLangString;
          localObject2 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
          bozv.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
          AETemplateInfoFragment.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject2, (String)localObject1, paramVarArgs.jdField_a_of_type_JavaLangString, paramVarArgs.f, paramVarArgs.i);
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 655362)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof boqu)))
        {
          paramVarArgs = (boqu)paramVarArgs[0];
          if (paramVarArgs.equals(bowt.a))
          {
            bozv.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("url", paramVarArgs.n);
            ((Intent)localObject2).putExtra("loc_play_show_tab_name", (String)localObject1);
            ((Intent)localObject2).putExtra("loc_play_show_material_id", paramVarArgs.jdField_a_of_type_JavaLangString);
            ((Intent)localObject2).putExtra("key_camera_material_name", paramVarArgs.i);
            ((Intent)localObject2).putExtra("VIDEO_STORY_FROM_TYPE", AETemplateInfoFragment.a(this.jdField_a_of_type_AndroidAppActivity));
            this.jdField_a_of_type_AndroidAppActivity.startActivity((Intent)localObject2);
          }
        }
      }
      else if (paramInt == 655363)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof boqu)))
        {
          paramVarArgs = (boqu)paramVarArgs[0];
          if (paramVarArgs.equals(bowt.a))
          {
            bozv.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = new LaunchParam();
            ((LaunchParam)localObject1).miniAppId = paramVarArgs.o;
            ((LaunchParam)localObject1).scene = 2083;
            MiniAppController.startAppByAppid(this.jdField_a_of_type_AndroidAppActivity, ((LaunchParam)localObject1).miniAppId, null, null, (LaunchParam)localObject1, null);
          }
        }
      }
      else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
      {
        o();
        localObject1 = (String)paramVarArgs[0];
        paramVarArgs = (String)paramVarArgs[1];
        if (this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView != null)
        {
          localObject2 = this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.a();
          if (localObject2 != null)
          {
            paramInt = i;
            while (paramInt < ((List)localObject2).size())
            {
              bpwm localbpwm = (bpwm)((List)localObject2).get(paramInt);
              if ((localbpwm != null) && (((String)localObject1).equals(localbpwm.jdField_a_of_type_JavaLangString)))
              {
                a(paramInt);
                this.jdField_a_of_type_AndroidSupportV4ViewViewPager.post(new AEPlayShowPart.4(this, (String)localObject1, paramVarArgs));
                return;
              }
              paramInt += 1;
            }
          }
        }
      }
    }
  }
  
  protected void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramView);
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView = ((AEPlayShowTabView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372778));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381244));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131381250));
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setTabCheckListener(new boxc(this));
    this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter = new PlayViewPagerAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Bown, a());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new boxd(this));
    e();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      bpam.b("AEPlayShowPart", "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      if (b()) {
        ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
      }
    }
    while (paramInt != 116) {
      return;
    }
    bpam.b("AEPlayShowPart", "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
    this.jdField_a_of_type_Bowy.c();
  }
  
  public void g()
  {
    super.g();
    bowt.a = null;
    bowt.c();
    if (this.jdField_a_of_type_Boqr != null) {
      this.jdField_a_of_type_Boqr.a(this);
    }
    if (this.jdField_a_of_type_Bowy != null)
    {
      this.jdField_a_of_type_Bowy.a(this);
      this.jdField_a_of_type_Bowy.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     boxb
 * JD-Core Version:    0.7.0.1
 */