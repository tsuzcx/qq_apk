import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.util.SparseArray;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class bjyj
  extends bjxl
{
  public SparseArray<teq> a;
  
  public bjyj(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray(6);
  }
  
  @NonNull
  private List<Long> a(@NonNull List<String> paramList)
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
        ved.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
      }
    }
    return localArrayList;
  }
  
  private void d()
  {
    Activity localActivity = a().getActivity();
    if (localActivity != null)
    {
      Intent localIntent = new Intent(localActivity, ShareToActivity.class);
      teq localteq = (teq)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bjxn.a());
      if (!teq.a(localteq)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localteq.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void j()
  {
    bjss localbjss = (bjss)super.a(bjss.class);
    if (teq.a((teq)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bjxn.a())))
    {
      localbjss.a(2130845934);
      return;
    }
    localbjss.a(2130845935);
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
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Bjxn.a(), new teq(paramIntent));
        }
      }
      this.jdField_a_of_type_Bjxn.a(0);
      j();
    }
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    Object localObject = (teq)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (teq.a((teq)localObject)) {}
    for (;;)
    {
      return;
      localObject = a(((teq)localObject).a);
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
      if (((List)localObject).size() > 0)
      {
        localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        localVideoSpreadGroupList.group_list.set((List)localObject);
        localVideoSpreadGroupList.visibility_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
      }
      for (parambkld.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray(); QLog.isColorLevel(); parambkld.a.spreadGroupBytes = null)
      {
        QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + parambkld.a.spreadGroupBytes);
        return;
      }
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return super.a(paramMessage);
      j();
    }
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjyj
 * JD-Core Version:    0.7.0.1
 */