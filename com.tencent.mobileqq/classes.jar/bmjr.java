import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bmjr
  extends bmiv
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public bmjr(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bmix.a.a("shareGroupId");
    this.b = this.jdField_a_of_type_Bmix.a.a("shareGroupName");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bmix.a.a("ignorePersonalPublish", false);
    wsv.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s", this.jdField_a_of_type_JavaLangString, this.b, Boolean.valueOf(this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131376505));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bmjs(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      wsv.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull bmwn parambmwn)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_Bmix)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = parambmwn.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(parambmwn.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        parambmwn.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        wsv.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString, this.b });
        parambmwn.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          wsv.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmjr
 * JD-Core Version:    0.7.0.1
 */