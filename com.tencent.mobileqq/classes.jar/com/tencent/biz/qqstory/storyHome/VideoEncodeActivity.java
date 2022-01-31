package com.tencent.biz.qqstory.storyHome;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.videoupload.VideoCompositeHelper;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import nud;

public class VideoEncodeActivity
  extends QQStoryBaseActivity
{
  private static final DateFormat jdField_a_of_type_JavaTextDateFormat = new SimpleDateFormat("MM-dd-HHmmSS");
  private Button jdField_a_of_type_AndroidWidgetButton;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private String jdField_a_of_type_JavaLangString;
  private EditText jdField_b_of_type_AndroidWidgetEditText;
  private String jdField_b_of_type_JavaLangString;
  private EditText c;
  private EditText d;
  private EditText e;
  
  private List a()
  {
    Object localObject = QQStoryContext.a().a().createEntityManager();
    new PublishVideoEntry();
    localObject = VideoCompositeHelper.a((EntityManager)localObject, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return new ArrayList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
      if (TextUtils.isEmpty(localPublishVideoEntry.name)) {
        localIterator.remove();
      } else {
        SLog.c("Q.qqstory:VideoEncodeActivity", "user scene " + localPublishVideoEntry);
      }
    }
    return localObject;
  }
  
  private void a()
  {
    Button localButton = (Button)findViewById(2131372091);
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString))
    {
      localButton.setEnabled(false);
      return;
    }
    localButton.setEnabled(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViewsInLayout();
    Object localObject = a();
    if (((List)localObject).size() == 0) {
      return;
    }
    RadioGroup localRadioGroup = new RadioGroup(this);
    localRadioGroup.setOrientation(1);
    localRadioGroup.setOnCheckedChangeListener(new nud(this));
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(localRadioGroup);
    RadioButton localRadioButton = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      localRadioButton = new RadioButton(this);
      localRadioGroup.addView(localRadioButton);
      localRadioButton.setText(localPublishVideoEntry.name);
      localRadioButton.setTag(localPublishVideoEntry.fakeVid);
      localRadioButton.setTextColor(getResources().getColor(2131492971));
    }
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
    a();
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130970872);
    super.setTitle("视频压缩测试");
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131372089));
    this.jdField_a_of_type_AndroidWidgetButton.setEnabled(false);
    this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372088));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131372090));
    this.jdField_b_of_type_AndroidWidgetEditText = ((EditText)findViewById(2131372092));
    this.c = ((EditText)findViewById(2131372093));
    this.d = ((EditText)findViewById(2131372094));
    this.e = ((EditText)findViewById(2131372097));
    b();
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 20000)
    {
      paramIntent = QQStoryContext.a().a().createEntityManager();
      localObject = paramIntent.a(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        break label70;
      }
      SLog.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: 0");
    }
    for (;;)
    {
      return;
      label70:
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
        SLog.d("Q.qqstory:VideoEncodeActivity", "createStoryVideo: fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s", new Object[] { localPublishVideoEntry.fakeVid, Integer.valueOf(localPublishVideoEntry.publishState), localPublishVideoEntry.videoLabel, localPublishVideoEntry.videoDoodleDescription, Long.valueOf(localPublishVideoEntry.videoDuration), localPublishVideoEntry.videoLocationDescription });
        localPublishVideoEntry.publishState = 0;
        localPublishVideoEntry.setStatus(1000);
        paramIntent.b(localPublishVideoEntry);
        this.jdField_a_of_type_JavaLangString = localPublishVideoEntry.fakeVid;
        this.jdField_a_of_type_AndroidWidgetButton.setEnabled(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity
 * JD-Core Version:    0.7.0.1
 */