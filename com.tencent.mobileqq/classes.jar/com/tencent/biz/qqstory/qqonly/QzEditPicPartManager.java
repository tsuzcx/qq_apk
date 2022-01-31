package com.tencent.biz.qqstory.qqonly;

import android.view.View;
import com.tencent.biz.qqstory.takevideo.EditPicPartManager;
import com.tencent.biz.qqstory.takevideo.EditSyncToStory;
import com.tencent.biz.qqstory.takevideo.EditTimerDelete;
import com.tencent.mobileqq.activity.richmedia.EditPicQzComment;
import java.util.ArrayList;
import java.util.List;

public class QzEditPicPartManager
  extends EditPicPartManager
{
  public int a;
  public View a;
  private EditTimerDelete jdField_a_of_type_ComTencentBizQqstoryTakevideoEditTimerDelete;
  private EditPicQzComment jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditPicQzComment;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b = -1;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d = -1;
  public String d;
  public boolean d;
  public String e;
  public boolean e = true;
  public boolean f;
  
  public QzEditPicPartManager()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_c_of_type_Int = -1;
  }
  
  protected void a(List paramList)
  {
    Object localObject = new EditPicQzComment(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaEditPicQzComment = ((EditPicQzComment)localObject);
    paramList.add(localObject);
    localObject = new EditTimerDelete(this);
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditTimerDelete = ((EditTimerDelete)localObject);
    paramList.add(localObject);
    if (this.f) {
      paramList.add(new EditSyncToStory(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.qqonly.QzEditPicPartManager
 * JD-Core Version:    0.7.0.1
 */