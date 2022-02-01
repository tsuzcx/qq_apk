package com.tencent.biz.qqcircle.hippy;

import aaaf;
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
import tmn;
import uxo;
import voc;
import vod;
import vrh;
import vri;
import zwp;
import zwr;

public class QCircleHippyFragment
  extends ViolaFragment
  implements zwr
{
  private long jdField_a_of_type_Long;
  private QCircleHippyBean jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean;
  private String b;
  private String c;
  
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
  
  private HashMap<String, Object> b()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(tmn.b, Integer.valueOf(1));
    localHashMap.put(tmn.h, Boolean.valueOf(true));
    localHashMap.put(tmn.i, Boolean.valueOf(false));
    localHashMap.put(tmn.v, Boolean.valueOf(false));
    localHashMap.put(tmn.j, Boolean.valueOf(true));
    return localHashMap;
  }
  
  private void b(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    JSONObject localJSONObject = new JSONObject();
    if ((paramBundle != null) && (paramBundle.containsKey("param"))) {}
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(paramBundle.getString("param"));
        this.jdField_a_of_type_Tmn.a(paramViewGroup, new voc(this));
        this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.initHippy(a(), paramBundle, this.jdField_a_of_type_Tmn.b(), new vod(this));
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
  
  private void w()
  {
    View localView = new View(getActivity());
    localView.setBackgroundColor(1711276032);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    ((ViewGroup)getActivity().getWindow().getDecorView()).addView(localView, localLayoutParams);
  }
  
  private void x()
  {
    uxo.a(getActivity(), this.c);
    if (getActivity() != null) {
      getActivity().finish();
    }
  }
  
  public void a(Bundle paramBundle, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean = ((QCircleHippyBean)paramBundle.getSerializable("key_hippy_bean"));
    if (this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean != null)
    {
      this.b = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getModuleName();
      this.c = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getDefaultUrl();
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentBizQqcircleQCircleHippyBean.getStartTime();
      if (TextUtils.isEmpty(this.b)) {
        break label154;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QCircleHippyFragment", 2, "Hippy: moduleName=" + this.b);
      }
      if (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null) {
        this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine = new HippyQQEngine(this, this.b);
      }
      this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.setInitData(a());
      b(paramBundle, paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Tmn.a(b(), paramViewGroup);
      b();
      return;
      label154:
      x();
      vrh.a("key_open_hippy_page", Arrays.asList(new FeedCloudCommon.Entry[] { vri.a("ret_code", "-2"), vri.a("attach_info", "request module name is null!") }), false);
    }
  }
  
  public ArrayList<Class> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(QCircleRefreshHippyPageEvent.class);
    return localArrayList;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    if (aaaf.a()) {
      w();
    }
    zwp.a().a(this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    zwp.a().b(this);
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof QCircleRefreshHippyPageEvent))
    {
      paramSimpleBaseEvent = (QCircleRefreshHippyPageEvent)paramSimpleBaseEvent;
      if ((!this.b.equals(paramSimpleBaseEvent.mModule)) || (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine == null) || (this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine() == null)) {}
    }
    try
    {
      paramSimpleBaseEvent = new HippyMap();
      paramSimpleBaseEvent.pushString("result", "call refresh hippy from native");
      ((EventDispatcher)this.jdField_a_of_type_ComTencentHippyQqAppHippyQQEngine.getHippyEngine().getEngineContext().getModuleManager().getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("refreshData", paramSimpleBaseEvent);
      QLog.d("QCircleHippyFragment", 1, "notify hippy refresh page data success,module:" + this.b);
      return;
    }
    catch (Exception paramSimpleBaseEvent)
    {
      QLog.e("QCircleHippyFragment", 1, "refresh hippy page fail!exception: " + paramSimpleBaseEvent.getMessage() + ",module:" + this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.hippy.QCircleHippyFragment
 * JD-Core Version:    0.7.0.1
 */