package com.tencent.biz.pubaccount.readinjoy.view.headers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.widget.ListView;
import mor;
import mos;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyDiandianHeaderController
  extends HeaderViewController
{
  private View jdField_a_of_type_AndroidViewView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new mor(this);
  private ListView jdField_a_of_type_ComTencentWidgetListView;
  private View b;
  
  public ReadInJoyDiandianHeaderController(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2130969594, null);
    this.b = this.jdField_a_of_type_AndroidViewView.findViewById(2131367041);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new mos(this));
    f();
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  private void a(String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    if (ReadInJoyLogicEngine.a().c() > 0) {}
    for (int i = 1;; i = 2) {
      try
      {
        localJSONObject.put("is_folder", i);
        a(paramString, localJSONObject);
        return;
      }
      catch (JSONException paramString)
      {
        throw new IllegalArgumentException("fail to construct json object");
      }
    }
  }
  
  private void e()
  {
    if (ReadInJoyLogicEngine.a().a()) {
      if (this.jdField_a_of_type_ComTencentWidgetListView.findHeaderViewPosition(this.jdField_a_of_type_AndroidViewView) < 0) {
        this.jdField_a_of_type_ComTencentWidgetListView.addHeaderView(this.jdField_a_of_type_AndroidViewView);
      }
    }
    for (;;)
    {
      f();
      return;
      this.jdField_a_of_type_ComTencentWidgetListView.removeHeaderView(this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  private void f()
  {
    int i = ReadInJoyLogicEngine.a().c();
    View localView = this.b;
    if (i > 0) {}
    for (i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  private void g()
  {
    ReadInJoyLogicEngine.a().g(0);
    ReadInJoyLogicEngine.a().h((int)NetConnInfoCenter.getServerTime());
    this.b.setVisibility(4);
  }
  
  protected void a()
  {
    a("0X8008B86");
  }
  
  public void a(ListView paramListView)
  {
    this.jdField_a_of_type_ComTencentWidgetListView = paramListView;
    e();
  }
  
  public void b()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.headers.ReadInJoyDiandianHeaderController
 * JD-Core Version:    0.7.0.1
 */