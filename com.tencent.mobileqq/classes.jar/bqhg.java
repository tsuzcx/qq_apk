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

public class bqhg
  extends bqgi
{
  public SparseArray<wuy> a;
  
  public bqhg(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
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
        yuk.e("Q.qqstory.publish.edit.EditVideoPermission", "can't format uin:%s", new Object[] { str });
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
      wuy localwuy = (wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bqgk.a());
      if (!wuy.a(localwuy)) {
        localIntent.putStringArrayListExtra("share_to_group_key", new ArrayList(localwuy.a));
      }
      localActivity.startActivityForResult(localIntent, 5555);
    }
  }
  
  private void j()
  {
    bqbp localbqbp = (bqbp)super.a(bqbp.class);
    if (wuy.a((wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Bqgk.a())))
    {
      localbqbp.a(2130846841);
      return;
    }
    localbqbp.a(2130846842);
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
          this.jdField_a_of_type_AndroidUtilSparseArray.put(this.jdField_a_of_type_Bqgk.a(), new wuy(paramIntent));
        }
      }
      this.jdField_a_of_type_Bqgk.a(0);
      j();
    }
  }
  
  public void a(int paramInt, @NonNull bqua parambqua)
  {
    super.a(paramInt, parambqua);
    Object localObject = (wuy)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (wuy.a((wuy)localObject)) {}
    for (;;)
    {
      return;
      localObject = a(((wuy)localObject).a);
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList;
      if (((List)localObject).size() > 0)
      {
        localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
        localVideoSpreadGroupList.group_list.set((List)localObject);
        localVideoSpreadGroupList.visibility_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
      }
      for (parambqua.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray(); QLog.isColorLevel(); parambqua.a.spreadGroupBytes = null)
      {
        QLog.d("zivonchen", 2, "editVideoPrePublish fragmentIndex = " + paramInt + ", shareGroupArray: " + parambqua.a.spreadGroupBytes);
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
 * Qualified Name:     bqhg
 * JD-Core Version:    0.7.0.1
 */