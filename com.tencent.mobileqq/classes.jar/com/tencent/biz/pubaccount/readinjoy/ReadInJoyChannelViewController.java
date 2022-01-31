package com.tencent.biz.pubaccount.readinjoy;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyVideoChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoUIManager.OnScreenChangeListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListView;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import las;

public class ReadInJoyChannelViewController
  extends ReadInJoyBaseViewController
  implements VideoUIManager.OnScreenChangeListener
{
  private static boolean jdField_a_of_type_Boolean = true;
  int jdField_a_of_type_Int;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  protected ReadInJoyObserver a;
  private VideoPlayManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  private VideoRecommendManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  private VideoUIManager jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager;
  ReadInJoyBaseAdapter jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter;
  private ReadInJoyBaseListViewGroup jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  public Map a;
  private int jdField_b_of_type_Int = -1;
  private Map jdField_b_of_type_JavaUtilMap = new HashMap();
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private Map jdField_c_of_type_JavaUtilMap = new HashMap();
  private int d = -1;
  
  public ReadInJoyChannelViewController(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new las(this);
  }
  
  private int a()
  {
    if (this.jdField_b_of_type_Int != -1) {
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_id", 0);
  }
  
  private Map a(Integer paramInteger)
  {
    Map localMap = (Map)this.jdField_c_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.jdField_c_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  private boolean a(Integer paramInteger)
  {
    paramInteger = (Boolean)this.jdField_a_of_type_JavaUtilMap.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  private int b()
  {
    if (this.jdField_c_of_type_Int != -1) {
      return this.jdField_c_of_type_Int;
    }
    return this.jdField_a_of_type_AndroidAppActivity.getIntent().getIntExtra("channel_type", 0);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup;
  }
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public VideoPlayManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager;
  }
  
  public VideoRecommendManager a()
  {
    return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager;
  }
  
  public ReadInJoyBaseListView a()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131367322) instanceof ReadInJoyBaseListView))) {
      return (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131367322);
    }
    return null;
  }
  
  public Set a(Integer paramInteger)
  {
    Set localSet = (Set)this.jdField_b_of_type_JavaUtilMap.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.jdField_b_of_type_JavaUtilMap.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager = new VideoRecommendManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager = new VideoPlayManager(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager);
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(a()), Boolean.valueOf(true));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup = new ReadInJoyListViewGroup(this, a(), b(), this.d, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter = ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.e();
    }
    String str;
    if (((this.jdField_a_of_type_AndroidAppActivity instanceof ReadInJoyNewFeedsActivity)) || ((this.jdField_a_of_type_AndroidAppActivity instanceof SplashActivity)))
    {
      str = VideoReporter.b();
      VideoReporter.a.put(ReadInJoyVideoChannelFragment.class, str);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(str);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoRecommendManager.a(str);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager = new VideoUIManager((FrameLayout)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131367142), (ReadInJoyBaseListView)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.findViewById(2131367322), this.jdField_a_of_type_AndroidAppActivity);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoUIManager.a(this);
      ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
      if (jdField_a_of_type_Boolean)
      {
        jdField_a_of_type_Boolean = false;
        ReadInJoyLogicEngine.a().c();
      }
      b();
      return;
      str = (String)VideoReporter.a.get(ReadInJoyChannelActivity.class);
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramInt1, paramInt2, paramIntent);
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    super.a(paramViewGroup);
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(paramBoolean);
  }
  
  public void b()
  {
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = true;
        super.b();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.b(this.jdField_a_of_type_JavaUtilMap);
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    ViewGroup.LayoutParams localLayoutParams = new ViewGroup.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup, localLayoutParams);
  }
  
  public void b(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    View localView1;
    View localView2;
    View localView3;
    View localView4;
    View localView5;
    if ((a() instanceof SplashActivity))
    {
      localView1 = a().findViewById(2131364935);
      localView2 = a().findViewById(2131363825);
      localView3 = a().findViewById(16908307);
      localView4 = a().findViewById(16908305);
      localView5 = a().findViewById(2131362327);
      if (paramBoolean)
      {
        if (localView4 != null)
        {
          this.jdField_a_of_type_Int = localView4.getPaddingBottom();
          localView4.setPadding(0, 0, 0, 0);
        }
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
        if (localView5 != null) {
          localView5.setVisibility(8);
        }
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        if (localView3 != null) {
          localView3.setVisibility(8);
        }
        FrameHelperActivity.b(false);
      }
    }
    label252:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (localView1 != null) {
                localView1.setVisibility(0);
              }
              if (localView5 != null) {
                localView5.setVisibility(0);
              }
              if (localView2 != null) {
                localView2.setVisibility(0);
              }
              if (localView3 != null) {
                localView3.setVisibility(0);
              }
              if (localView4 != null) {
                localView4.setPadding(0, 0, 0, this.jdField_a_of_type_Int);
              }
              FrameHelperActivity.b(true);
              return;
              if (!(a() instanceof ReadInJoyChannelActivity)) {
                break label252;
              }
              localView1 = a().findViewById(2131363244);
              if (!paramBoolean) {
                break;
              }
            } while (localView1 == null);
            localView1.setVisibility(8);
            return;
          } while (localView1 == null);
          localView1.setVisibility(0);
          return;
        } while (!(a() instanceof ReadInJoyNewFeedsActivity));
        localView1 = a().findViewById(2131367091);
        localView2 = a().findViewById(2131363513);
        localView3 = a().findViewById(2131366819);
        localView4 = a().findViewById(2131366817);
        localView5 = a().findViewById(2131366818);
        if (!paramBoolean) {
          break;
        }
        if (localView1 != null) {
          localView1.setVisibility(8);
        }
        if (localView2 != null) {
          localView2.setVisibility(8);
        }
        if (localView3 != null) {
          localView3.setVisibility(8);
        }
        if (localView4 != null) {
          localView4.setVisibility(8);
        }
      } while (localView5 == null);
      localView5.setVisibility(8);
      return;
      if (localView1 != null) {
        localView1.setVisibility(0);
      }
      if (localView2 != null) {
        localView2.setVisibility(0);
      }
      if (localView3 != null) {
        localView3.setVisibility(0);
      }
      if (localView4 != null) {
        localView4.setVisibility(0);
      }
    } while (localView5 == null);
    localView5.setVisibility(0);
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        this.jdField_b_of_type_Boolean = false;
        super.c();
      } while (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup == null);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    } while (this.jdField_a_of_type_AndroidViewViewGroup == null);
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup);
  }
  
  public void c(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void d()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.a(this.jdField_a_of_type_JavaUtilMap);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.c();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.d();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilMap.clear();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseAdapter.notifyDataSetChanged();
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.e();
  }
  
  public void f()
  {
    super.f();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.f();
  }
  
  public void g()
  {
    super.g();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void h()
  {
    super.h();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.e();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.c();
  }
  
  public void i()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).a(null, true);
    }
  }
  
  public void j()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup))) {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).n();
    }
  }
  
  public void k()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoVideoPlayManager.d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup.d();
  }
  
  public void l()
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup != null) && ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup instanceof ReadInJoyListViewGroup)))
    {
      ((ReadInJoyListViewGroup)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyBaseListViewGroup).b(a(Integer.valueOf(a())), a(Integer.valueOf(a())));
      a(Integer.valueOf(a())).clear();
      this.jdField_b_of_type_JavaUtilMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewController
 * JD-Core Version:    0.7.0.1
 */