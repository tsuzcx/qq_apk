package com.tencent.biz.pubaccount.readinjoy.viola;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.biz.richframework.eventbus.SimpleEventBus;
import com.tencent.biz.richframework.eventbus.SimpleEventReceiver;
import com.tencent.mobileqq.activity.miniaio.MiniPieJumpToAioEvent;
import com.tencent.mobileqq.colornote.ColorNoteController;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.data.ColorNote.Builder;
import com.tencent.mobileqq.colornote.data.ColorNoteUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaColorNote
  implements SimpleEventReceiver<MiniPieJumpToAioEvent>
{
  private ColorNoteController jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController;
  private final ColorNote jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  private String jdField_a_of_type_JavaLangString;
  private JSONObject jdField_a_of_type_OrgJsonJSONObject;
  private boolean jdField_a_of_type_Boolean;
  private ColorNote jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private final boolean c;
  
  public ViolaColorNote(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote = new ColorNote.Builder().a(16908290).a("viola:" + paramString).b("defaultTitle").c("defaultSubTitle").d("https://default").a();
    if (Aladdin.getConfig(417).getIntegerFromString("open_auto_color_ball", 0) == 1) {}
    for (;;)
    {
      this.c = bool;
      if (this.c)
      {
        this.jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote = ColorNoteUtils.a(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
        SimpleEventBus.getInstance().registerReceiver(this);
      }
      return;
      bool = false;
    }
  }
  
  public static JSONObject a(ColorNote paramColorNote)
  {
    if (paramColorNote == null) {
      return new JSONObject();
    }
    try
    {
      paramColorNote = new JSONObject(new String(paramColorNote.getReserve()));
      return paramColorNote;
    }
    catch (Exception paramColorNote)
    {
      QLog.d("ViolaColorNote", 1, "[getViolaColorNoteData]: " + paramColorNote.getMessage());
    }
    return new JSONObject();
  }
  
  public static JSONObject b(ColorNote paramColorNote)
  {
    return a(paramColorNote).optJSONObject("report");
  }
  
  private void c(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_OrgJsonJSONObject == null) {
        this.jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
      }
      Iterator localIterator = paramJSONObject.keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        try
        {
          this.jdField_a_of_type_OrgJsonJSONObject.put(str, paramJSONObject.opt(str));
        }
        catch (JSONException localJSONException)
        {
          QLog.e("ViolaColorNote", 1, localJSONException.getMessage());
        }
      }
    }
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_OrgJsonJSONObject == null) || (this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote == null)) {
      return;
    }
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mMainTitle = this.jdField_a_of_type_OrgJsonJSONObject.optString("title");
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mSubTitle = this.jdField_a_of_type_OrgJsonJSONObject.optString("subTitle");
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mPicUrl = this.jdField_a_of_type_OrgJsonJSONObject.optString("imageUrl");
      this.jdField_a_of_type_OrgJsonJSONObject.put("param", this.jdField_a_of_type_JavaLangString).put("url", this.jdField_b_of_type_JavaLangString).put("useTransParentFragment", this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote.mReserve = this.jdField_a_of_type_OrgJsonJSONObject.toString().getBytes();
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("ViolaColorNote", 1, "[setColorBallData]: " + localException.getMessage());
    }
  }
  
  private void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote == null) || (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController == null)) {}
    do
    {
      return;
      b();
      d();
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.n();
    } while (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a());
    QLog.e("ViolaColorNote", 1, "ColorNote Not Ready");
  }
  
  public ViolaColorNote a(ColorNoteController paramColorNoteController)
  {
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController = paramColorNoteController;
    return this;
  }
  
  public ViolaColorNote a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ViolaColorNote a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public ColorNote a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqColornoteDataColorNote;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController == null) {}
    do
    {
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c()) {
        d();
      }
    } while ((this.jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote == null) || (!this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.a(this.jdField_b_of_type_ComTencentMobileqqColornoteDataColorNote)));
    d();
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.n();
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController == null) {}
    while (1 != paramInt) {
      return;
    }
    d();
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    do
    {
      return;
      c(paramJSONObject);
    } while (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController == null);
    this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.k();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_OrgJsonJSONObject == null) {}
    JSONObject localJSONObject;
    do
    {
      return;
      localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject.optJSONObject("report");
    } while (localJSONObject == null);
    try
    {
      localJSONObject.put("add_way", 3);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e("ViolaColorNote", 1, "changeAddWayToMiniAio error");
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    c(paramJSONObject);
  }
  
  public void c()
  {
    if (this.jdField_b_of_type_Boolean) {
      e();
    }
    if (this.c) {
      SimpleEventBus.getInstance().unRegisterReceiver(this);
    }
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController != null) {
      this.jdField_a_of_type_ComTencentMobileqqColornoteColorNoteController.c();
    }
  }
  
  public ArrayList<Class<MiniPieJumpToAioEvent>> getEventClass()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(MiniPieJumpToAioEvent.class);
    return localArrayList;
  }
  
  public void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent)
  {
    if ((paramSimpleBaseEvent instanceof MiniPieJumpToAioEvent)) {
      this.jdField_b_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaColorNote
 * JD-Core Version:    0.7.0.1
 */