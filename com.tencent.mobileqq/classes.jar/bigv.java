import android.support.annotation.NonNull;
import android.widget.TextView;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.VideoSpreadGroupList;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;

public class bigv
  extends bifz
{
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  
  public bigv(@NonNull bigb parambigb)
  {
    super(parambigb);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_Bigb.a.a("shareGroupId");
    this.b = this.jdField_a_of_type_Bigb.a.a("shareGroupName");
    this.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bigb.a.a("ignorePersonalPublish", false);
    urk.a("EditVideoShareGroup", "shareGroupId=%s, shareGroupName=%s, ignorePersonalPublish=%s", this.jdField_a_of_type_JavaLangString, this.b, Boolean.valueOf(this.jdField_a_of_type_Boolean));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131310237));
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.b);
    this.jdField_a_of_type_AndroidWidgetTextView.setOnClickListener(new bigw(this));
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      urk.e("EditVideoShareGroup", "shareGroupId should not be null");
      a().a(0, null, 0, 0);
    }
  }
  
  public void a(int paramInt, @NonNull bitz parambitz)
  {
    if (this.jdField_a_of_type_JavaLangString != null) {}
    synchronized (this.jdField_a_of_type_Bigb)
    {
      qqstory_struct.VideoSpreadGroupList localVideoSpreadGroupList = new qqstory_struct.VideoSpreadGroupList();
      byte[] arrayOfByte = parambitz.a.spreadGroupBytes;
      if (arrayOfByte != null) {}
      try
      {
        localVideoSpreadGroupList.mergeFrom(parambitz.a.spreadGroupBytes);
        localVideoSpreadGroupList.share_group_list.add(ByteStringMicro.copyFromUtf8(this.jdField_a_of_type_JavaLangString));
        localVideoSpreadGroupList.visibility_sharegroup_type.set(2);
        localVideoSpreadGroupList.setHasFlag(true);
        parambitz.a.spreadGroupBytes = localVideoSpreadGroupList.toByteArray();
        urk.d("EditVideoShareGroup", "editVideoPrePublish fragment index = %d, share-group %s %s", new Object[] { Integer.valueOf(paramInt), this.jdField_a_of_type_JavaLangString, this.b });
        parambitz.a.putExtra("ignorePersonalPublish", Boolean.valueOf(this.jdField_a_of_type_Boolean));
        return;
      }
      catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
      {
        for (;;)
        {
          urk.c("EditVideoShareGroup", "editVideoPrePublish error", localInvalidProtocolBufferMicroException);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bigv
 * JD-Core Version:    0.7.0.1
 */