package com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.TextView;
import com.tencent.biz.qqstory.takevideo.label.QQStoryAddVideoLabelViewPart;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.XEditTextEx;

public class EditVideoLabel
  extends EditVideoPart
  implements View.OnClickListener
{
  protected ViewStub a;
  protected TextView a;
  protected QQStoryAddVideoLabelViewPart a;
  protected String a;
  
  public EditVideoLabel(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
  }
  
  private void g()
  {
    i();
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() != 0)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(0);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a.requestFocus();
      InputMethodUtil.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a);
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart != null) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() == 0))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(4);
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a);
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a.clearFocus();
    }
  }
  
  private void i()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart = new QQStoryAddVideoLabelViewPart(this.jdField_a_of_type_AndroidViewViewStub.inflate());
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a(new EditVideoLabel.2(this));
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.b(new EditVideoLabel.3(this));
    }
  }
  
  @Nullable
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362203));
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnTouchListener(new EditVideoLabel.1(this));
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    paramGenerateContext.a.videoLabel = a();
    EditVideoPartManager localEditVideoPartManager;
    String str;
    if (!TextUtils.isEmpty(a()))
    {
      paramInt = 1;
      if (paramInt != 0)
      {
        localEditVideoPartManager = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager;
        str = a();
        if (!this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a()) {
          break label89;
        }
      }
    }
    label89:
    for (paramGenerateContext = "2";; paramGenerateContext = "1")
    {
      localEditVideoPartManager.a("pub_tag", 0, 0, new String[] { "1", str, paramGenerateContext });
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      h();
      return;
    case 0: 
      h();
      return;
    }
    g();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart != null)
    {
      bool1 = bool2;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoLabelQQStoryAddVideoLabelViewPart.a() == 0)
      {
        this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d() {}
  
  public void onClick(View paramView)
  {
    paramView.getId();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoLabel
 * JD-Core Version:    0.7.0.1
 */