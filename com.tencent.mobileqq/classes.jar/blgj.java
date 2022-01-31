import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.TargetApi;
import android.app.Activity;
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

public class blgj
  extends blfs
  implements azga
{
  private ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private bkpl jdField_a_of_type_Bkpl;
  private bkzy jdField_a_of_type_Bkzy;
  private blfq jdField_a_of_type_Blfq;
  private blgg jdField_a_of_type_Blgg;
  private AEPlayShowTabView jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView;
  private PlayViewPagerAdapter jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private View c;
  
  public blgj(Activity paramActivity, ViewStub paramViewStub, blft paramblft)
  {
    super(paramActivity, paramViewStub, paramblft);
    this.jdField_a_of_type_Bkpl = ((bkpl)paramblft.a(65537, new Object[0]));
    this.jdField_a_of_type_Blgg = ((blgg)blqr.a().c(19));
    this.jdField_a_of_type_Bkzy = ((bkzy)blqr.a().c(18));
    ThreadManager.getFileThreadHandler().postAtFrontOfQueue(new AEPlayShowPart.1(this));
    this.jdField_a_of_type_Blgg.a(this, 1);
    this.jdField_a_of_type_Bkzy.a(this, 116);
    d();
    a(null);
  }
  
  private int a()
  {
    if ((this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter != null) && (this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a() != null)) {
      return this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a().getScrollY();
    }
    return 0;
  }
  
  private bkzx a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        bkzx localbkzx = (bkzx)((Iterator)localObject).next();
        if ((localbkzx != null) && (paramString != null) && (paramString.equals(localbkzx.b))) {
          return localbkzx;
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
      return ((bmbn)localArrayList.get(i)).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private String a(String paramString)
  {
    Object localObject = this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter.a();
    if (localObject != null)
    {
      bkzx localbkzx;
      blab localblab;
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
            localbkzx = (bkzx)((Iterator)localObject).next();
          } while ((localbkzx == null) || (localbkzx.jdField_a_of_type_JavaUtilList == null));
          localIterator = localbkzx.jdField_a_of_type_JavaUtilList.iterator();
        }
        localblab = (blab)localIterator.next();
      } while ((localblab == null) || (paramString == null) || (!paramString.equals(localblab.jdField_a_of_type_JavaLangString)));
      return localbkzx.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  private ArrayList<bmbn> a(List<bkzx> paramList)
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
          bkzx localbkzx = (bkzx)paramList.next();
          bmbn localbmbn = new bmbn();
          localbmbn.jdField_a_of_type_JavaLangString = localbkzx.b;
          localArrayList.add(localbmbn);
        }
        paramList = localArrayList;
      }
      finally {}
    }
  }
  
  @NonNull
  private List<bkzx> a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("AEPlayShowPart", 4, "getPlayShowCategories");
    }
    return this.jdField_a_of_type_Blgg.a();
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
        blab localblab = (blab)paramString1.get(i);
        if ((localblab != null) && (paramString2 != null) && (paramString2.equals(localblab.jdField_a_of_type_JavaLangString)))
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
  
  private void a(List<bkzx> paramList, List<bmbn> paramList1)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (CollectionUtils.isEmpty(paramList1)))
    {
      if (this.jdField_b_of_type_AndroidViewViewGroup == null)
      {
        this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewViewStub.inflate());
        this.jdField_b_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewViewGroup.findViewById(2131378630);
        this.jdField_b_of_type_AndroidViewView.setOnClickListener(new blgo(this));
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
        bkzx localbkzx;
        blab localblab;
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
                localbkzx = (bkzx)((Iterator)localObject1).next();
              } while (localbkzx == null);
              localObject2 = localbkzx.jdField_a_of_type_JavaUtilList;
            } while (localObject2 == null);
            localObject2 = ((List)localObject2).iterator();
          }
          localblab = (blab)((Iterator)localObject2).next();
        } while ((localblab == null) || (paramString == null) || (!paramString.equals(localblab.jdField_a_of_type_JavaLangString)));
        return localbkzx.b;
      }
    }
    return "";
  }
  
  private String c(String paramString)
  {
    if ((this.jdField_a_of_type_Bkpl != null) && (this.jdField_a_of_type_Bkpl.a() != null) && (this.jdField_a_of_type_Bkpl.a().getIntent() != null)) {
      return this.jdField_a_of_type_Bkpl.a().getIntent().getStringExtra(paramString);
    }
    return "";
  }
  
  private void d()
  {
    this.jdField_a_of_type_Blfq = ((blfq)bkpx.a(this.jdField_a_of_type_Bkpl).a(blfq.class));
    this.jdField_a_of_type_Blfq.a.a(this.jdField_a_of_type_Bkpl, new blgm(this));
    bkzr.c().a(this.jdField_a_of_type_Bkpl, new blgn(this));
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
      bkzx localbkzx = a(str2);
      localObject3 = new StringBuilder().append("chooseId: ").append((String)localObject1).append(" typeId: ").append((String)localObject3).append(" posTabName: ").append(str2).append(" isMaterial null: ");
      if (localbkzx == null) {}
      for (boolean bool = true;; bool = false)
      {
        bljn.a("AEPlayShowPart", bool);
        if ((localbkzx == null) || (!AECaptureMode.PLAY.name.equals(localObject2))) {
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
      this.c = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131559437, this.jdField_a_of_type_AndroidViewViewGroup, false);
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.c);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.c.getLayoutParams();
      localLayoutParams.addRule(13);
      this.c.setLayoutParams(localLayoutParams);
    }
    this.c.setVisibility(0);
  }
  
  private void k()
  {
    if (this.c != null) {
      this.c.setVisibility(8);
    }
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.setVisibility(8);
    }
  }
  
  @TargetApi(12)
  private void l()
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
      if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof blab)))
      {
        paramVarArgs = (blab)paramVarArgs[0];
        if (paramVarArgs.equals(blfz.a))
        {
          localObject1 = bkpg.b + File.separator + paramVarArgs.jdField_a_of_type_JavaLangString;
          localObject2 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
          bliy.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
          AETemplateInfoFragment.a(this.jdField_a_of_type_AndroidAppActivity, (String)localObject2, (String)localObject1, paramVarArgs.jdField_a_of_type_JavaLangString, paramVarArgs.f, paramVarArgs.i);
        }
      }
    }
    for (;;)
    {
      return;
      if (paramInt == 655362)
      {
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof blab)))
        {
          paramVarArgs = (blab)paramVarArgs[0];
          if (paramVarArgs.equals(blfz.a))
          {
            bliy.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = a(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject2 = new Intent(this.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
            ((Intent)localObject2).addFlags(536870912);
            ((Intent)localObject2).addFlags(67108864);
            ((Intent)localObject2).putExtra("url", paramVarArgs.m);
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
        if ((paramVarArgs != null) && (paramVarArgs.length == 1) && ((paramVarArgs[0] instanceof blab)))
        {
          paramVarArgs = (blab)paramVarArgs[0];
          if (paramVarArgs.equals(blfz.a))
          {
            bliy.a().d(paramVarArgs.jdField_a_of_type_JavaLangString);
            localObject1 = new LaunchParam();
            ((LaunchParam)localObject1).miniAppId = paramVarArgs.n;
            ((LaunchParam)localObject1).scene = 2083;
            MiniAppController.startAppByAppid(this.jdField_a_of_type_AndroidAppActivity, ((LaunchParam)localObject1).miniAppId, null, null, (LaunchParam)localObject1, null);
          }
        }
      }
      else if ((paramInt == 655364) && (paramVarArgs != null) && (paramVarArgs.length == 2) && ((paramVarArgs[0] instanceof String)) && ((paramVarArgs[1] instanceof String)))
      {
        j();
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
              bmbn localbmbn = (bmbn)((List)localObject2).get(paramInt);
              if ((localbmbn != null) && (((String)localObject1).equals(localbmbn.jdField_a_of_type_JavaLangString)))
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
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView = ((AEPlayShowTabView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131372096));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((ViewPager)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380101));
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131380106));
    this.jdField_a_of_type_DovComQqImAePlayAEPlayShowTabView.setTabCheckListener(new blgk(this));
    this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter = new PlayViewPagerAdapter(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_Blft, a());
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(this.jdField_a_of_type_DovComQqImAePlayPlayViewPagerAdapter);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(new blgl(this));
    e();
  }
  
  public void a(Object paramObject, int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 1)
    {
      bljn.b("AEPlayShowPart", "notify, eventId=AEPlayShowMaterialManager.EVENT_MATERIAL_LIST_UPDATED");
      if (a()) {
        ThreadManager.getUIHandler().post(new AEPlayShowPart.5(this));
      }
    }
    while (paramInt != 116) {
      return;
    }
    bljn.b("AEPlayShowPart", "notify, eventId=AEMaterialManager.TEMPLATE_INFO_LIST_UPDATE");
    this.jdField_a_of_type_Blgg.d();
  }
  
  public void g()
  {
    super.g();
    blfz.a = null;
    blfz.c();
    if (this.jdField_a_of_type_Bkzy != null) {
      this.jdField_a_of_type_Bkzy.a(this);
    }
    if (this.jdField_a_of_type_Blgg != null)
    {
      this.jdField_a_of_type_Blgg.a(this);
      this.jdField_a_of_type_Blgg.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blgj
 * JD-Core Version:    0.7.0.1
 */