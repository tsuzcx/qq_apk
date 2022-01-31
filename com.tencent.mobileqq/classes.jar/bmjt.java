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

public class bmjt
  extends bmiv
{
  public SparseArray<uti> a;
  
  public bmjt(@NonNull bmix parambmix)
  {
    super(parambmix);
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
        wsv.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
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
      uti localuti = (uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bmix.a());
      if (!uti.a(localuti)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localuti.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void j()
  {
    bmec localbmec = (bmec)super.a(bmec.class);
    if (uti.a((uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bmix.a())))
    {
      localbmec.a(2130846313);
      return;
    }
    localbmec.a(2130846314);
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
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Bmix.a(), new uti(paramIntent));
        }
      }
      this.jdField_a_of_type_Bmix.a(0);
      j();
    }
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    super.a(paramInt, parambmwn);
    Object localObject = (uti)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (uti.a((uti)localObject)) {}
    for (;;)
    {
      return;
      localObject = a(((uti)localObject).a);
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
      if (((List)localObject).size() > 0)
      {
        localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        localVideoSpreadGroupList.group_list.set((List)localObject);
        localVideoSpreadGroupList.visibility_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
      }
      for (parambmwn.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray(); QLog.isColorLevel(); parambmwn.a.spreadGroupBytes = null)
      {
        QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + parambmwn.a.spreadGroupBytes);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjt
 * JD-Core Version:    0.7.0.1
 */