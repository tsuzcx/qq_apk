package com.tencent.biz.qqstory.shareGroup.widget;

import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.MemoryInfoEntry;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.memory.controller.MemoryDataPuller;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem.FakeVideoUIItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

class StoryPickerFragment$6
  extends SimpleJob<Object>
{
  StoryPickerFragment$6(StoryPickerFragment paramStoryPickerFragment, String paramString1, String paramString2, VideoCollectionItem.FakeVideoUIItem paramFakeVideoUIItem, int paramInt, View paramView)
  {
    super(paramString1);
  }
  
  protected Object a(@NonNull JobContext paramJobContext, Void... paramVarArgs)
  {
    paramJobContext = QQStoryContext.a().b();
    Object localObject = (MemoryManager)SuperManager.a(19);
    paramVarArgs = new ArrayList();
    ArrayList localArrayList1 = ((MemoryManager)localObject).a(paramJobContext, paramVarArgs);
    if (localArrayList1 != null)
    {
      if (localArrayList1.size() == 0) {
        return null;
      }
      ArrayList localArrayList2 = new ArrayList();
      localArrayList2.add(this.jdField_a_of_type_JavaLangString);
      if (this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerFragment.a != null) {
        this.jdField_a_of_type_ComTencentBizQqstoryShareGroupWidgetStoryPickerFragment.a.b(localArrayList2, true);
      }
      int i = localArrayList1.indexOf(this.jdField_a_of_type_JavaLangString);
      localObject = ((MemoryManager)localObject).a(paramJobContext);
      boolean bool;
      if ((localObject != null) && (((MemoryInfoEntry)localObject).isEnd == 1)) {
        bool = true;
      } else {
        bool = false;
      }
      ThreadManager.getUIHandler().post(new StoryPickerFragment.6.1(this, paramJobContext, localArrayList1, i, paramVarArgs, bool));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.widget.StoryPickerFragment.6
 * JD-Core Version:    0.7.0.1
 */