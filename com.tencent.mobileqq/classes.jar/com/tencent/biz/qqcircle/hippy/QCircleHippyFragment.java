package com.tencent.biz.qqcircle.hippy;

import aaak;
import aaam;
import aaek;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.qqcircle.QCircleHippyBean;
import com.tencent.biz.qqcircle.events.QCircleRefreshHippyPageEvent;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.hippy.qq.app.HippyQQEngine;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudCommon.Entry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;
import tdl;
import uyx;
import vqk;
import vql;
import vts;
import vtt;

public class QCircleHippyFragment
  extends ViolaFragment
  implements aaam
{
  private long jdField_a_of_type_Long;
  private QCircleHippyBean jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  private HashMap<String, Object> a()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(tdl.b, Integer.valueOf(1));
    localHashMap.put(tdl.h, Boolean.valueOf(true));
    localHashMap.put(tdl.i, Boolean.valueOf(false));
    localHashMap.put(tdl.v, Boolean.valueOf(false));
    localHashMap.put(tdl.j, Boolean.valueOf(true));
    return localHashMap;
  }
  
  private JSONObject a()
  {
    if (getActivity() != null)
    {
      TicketManager localTicketManager = (TicketManager)getActivity().app.getManager(2);
      String str = getActivity().app.getCurrentAccountUin();
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("uin", str);
        localJSONObject.put("p_uin", str);
        localJSONObject.put("skey", localTicketManager.getSkey(str));
        localJSONObject.put("p_skey", localTicketManager.getPskey(str, "qzone.qq.com"));
        if ((this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getPersonalUin()))) {
          localJSONObject.put("host_uin", this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getPersonalUin());
        }
        return localJSONObject;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          localJSONException.printStackTrace();
        }
      }
    }
    return null;
  }
  
  private void a()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.mViolaUiDelegate.a(paramViewGroup, new vqk(this));
        this.mHippyQQEngine.initHippy(getContentView(), paramBundle, this.mViolaUiDelegate.b(), new vql(this));
        return;
      }
      catch (JSONException paramBundle)
      {
        paramBundle = localJSONObject;
        continue;
      }
      paramBundle = localJSONObject;
    }
  }
  
  private void b()
  {
    uyx.a(getActivity(), this.b, null, -1);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRefreshHippyPageEvent.class);
    return localArrayList;
  }
  
  public void initAfterVisible(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean = ((QCircleHippyBean)paramBundle.getSerializable("key_hippy_bean"));
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean != null)
    {
      this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getModuleName();
      this.b = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getDefaultUrl();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getStartTime();
      if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
        break label155;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleHippyFragment", 2, "Hippy: moduleName=" + this.jdField_a_of_type_JavaLangString);
      }
      if (this.mHippyQQEngine == null) {
        this.mHippyQQEngine = new HippyQQEngine(this, this.jdField_a_of_type_JavaLangString);
      }
      this.mHippyQQEngine.setInitData(a());
      a(paramBundle, paramViewGroup);
    }
    for (;;)
    {
      this.mViolaUiDelegate.a(a(), paramViewGroup);
      initFPS();
      return;
      label155:
      b();
      vts.a("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { vtt.a("ret_code", "-2"), vtt.a("attach_info", "request module name is null!") }), false);
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (aaek.a()) {
      a();
    }
    aaak.a().a(this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    aaak.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRefreshHippyPageEvent))
    {
      paramSimpleBaseEvent = (QCircleRefreshHippyPageEvent)paramSimpleBaseEvent;
      if ((!this.jdField_a_of_type_JavaLangString.equals(paramSimpleBaseEvent.mModule)) || (this.mHippyQQEngine == null) || (this.mHippyQQEngine.getHippyEngine() == null)) {}
    }
    try
    {
      paramSimpleBaseEvent = new HippyMap();
      paramSimpleBaseEvent.pushString("result", "call refresh hippy from native");
      ((EventDispatcher)this.mHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramSimpleBaseEvent);
      QLog.d("QCircleHippyFragment", 1, "notify hippy refresh page data success,module:" + this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception paramSimpleBaseEvent)
    {
      QLog.e("QCircleHippyFragment", 1, "refresh hippy page fail!exception: " + paramSimpleBaseEvent.getMessage() + ",module:" + this.jdField_a_of_type_JavaLangString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.hippy.QCircleHippyFragment
 * JD-Core Version:    0.7.0.1
 */