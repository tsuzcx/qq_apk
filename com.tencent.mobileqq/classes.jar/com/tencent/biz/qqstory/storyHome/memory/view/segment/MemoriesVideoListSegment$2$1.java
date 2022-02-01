package com.tencent.biz.qqstory.storyHome.memory.view.segment;

import android.app.Activity;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder;
import com.tencent.biz.qqstory.storyHome.memory.StoryMemoriesFragment;
import java.util.ArrayList;
import xlj;
import yjh;
import yku;
import ykw;
import yuk;
import yup;

public class MemoriesVideoListSegment$2$1
  implements Runnable
{
  public MemoriesVideoListSegment$2$1(ykw paramykw, ArrayList paramArrayList1, int paramInt, ArrayList paramArrayList2, QQUserUIItem paramQQUserUIItem) {}
  
  public void run()
  {
    Object localObject = new OpenPlayerBuilder(new MemoriesFeedPlayInfo(yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku).jdField_a_of_type_JavaLangString, (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int), this.jdField_a_of_type_Ykw.b, String.valueOf(yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku).hashCode()), this.b, yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku).b, 0), StoryMemoriesFragment.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku.jdField_a_of_type_Int));
    ((OpenPlayerBuilder)localObject).a(yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku));
    ((OpenPlayerBuilder)localObject).c();
    xlj.a((Activity)yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku), ((OpenPlayerBuilder)localObject).a(), this.jdField_a_of_type_Ykw.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem == null)
    {
      yuk.d("Q.qqstory.memories.MemoriesVideoListSegment", "userManager returns null with id %s", new Object[] { yku.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku).jdField_a_of_type_JavaLangString });
      return;
    }
    int i = StoryMemoriesFragment.a(this.jdField_a_of_type_Ykw.jdField_a_of_type_Yku.jdField_a_of_type_Int);
    if (this.jdField_a_of_type_ComTencentBizQqstoryModelItemQQUserUIItem.isMe()) {}
    for (localObject = "1";; localObject = "2")
    {
      yup.a("memory", "clk_video", i, 0, new String[] { localObject, "", "", this.jdField_a_of_type_Ykw.b });
      yuk.b("Q.qqstory.memories.MemoriesVideoListSegment", "go to player , collection key = %s, feedIds = %s , vid = %s , keyIndex = %s , video pos = %d , keyList = %s", new Object[] { this.jdField_a_of_type_Ykw.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaUtilArrayList, this.jdField_a_of_type_Ykw.b, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Ykw.jdField_a_of_type_Int), this.b });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.memory.view.segment.MemoriesVideoListSegment.2.1
 * JD-Core Version:    0.7.0.1
 */