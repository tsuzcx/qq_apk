package com.tencent.biz.qqstory.takevideo;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.VideoSpreadGroupList;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.publish.GenerateContext;
import com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EditVideoShareTo
  extends EditVideoPart
{
  public SparseArray a;
  
  public EditVideoShareTo(@NonNull EditVideoPartManager paramEditVideoPartManager)
  {
    super(paramEditVideoPartManager);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
  }
  
  @NonNull
  private List a(@NonNull List paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = (String)paramList.next();
      try
      {
        localArrayList.add(Long.valueOf(Long.valueOf(str).longValue()));
      }
      catch (NumberFormatException localNumberFormatException)
      {
        SLog.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void e()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, ShareToActivity.class);
      VideoSpreadGroupList localVideoSpreadGroupList = (VideoSpreadGroupList)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a());
      if (!VideoSpreadGroupList.a(localVideoSpreadGroupList)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localVideoSpreadGroupList.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void h()
  {
    EditButtonExport localEditButtonExport = (EditButtonExport)super.a(EditButtonExport.class);
    if (VideoSpreadGroupList.a((VideoSpreadGroupList)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a())))
    {
      localEditButtonExport.b(2130843621);
      return;
    }
    localEditButtonExport.b(2130843622);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 5555)
    {
      if (paramInt2 == 1)
      {
        paramIntent = paramIntent.getStringArrayListExtra("share_to_group_key");
        if (paramIntent != null) {
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(), new VideoSpreadGroupList(paramIntent));
        }
      }
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager.a(0);
      h();
    }
  }
  
  public void a(int paramInt, @NonNull GenerateContext paramGenerateContext)
  {
    super.a(paramInt, paramGenerateContext);
    ??? = (VideoSpreadGroupList)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (VideoSpreadGroupList.a((VideoSpreadGroupList)???)) {}
    for (;;)
    {
      return;
      List localList = a(((VideoSpreadGroupList)???).a);
      if (localList.size() > 0) {}
      synchronized (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPartManager)
      {
        qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        byte[] arrayOfByte = paramGenerateContext.a.spreadGroupBytes;
        if (arrayOfByte != null) {}
        try
        {
          localVideoSpreadGroupList.mergeFrom(paramGenerateContext.a.spreadGroupBytes);
          localVideoSpreadGroupList.group_list.set(localList);
          localVideoSpreadGroupList.visibility_type.set(2);
          localVideoSpreadGroupList.setHasFlag(true);
          paramGenerateContext.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
          SLog.d("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish fragment index = %d, qq-group count %d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(localList.size()) });
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + paramGenerateContext.a.spreadGroupBytes);
          return;
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            SLog.c("Q.qqstory.publish.edit.EditVideoPermission", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    e();
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoShareTo
 * JD-Core Version:    0.7.0.1
 */