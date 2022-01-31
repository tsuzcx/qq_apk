import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.activity.ForwardFriendListActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.JobSegment;
import java.io.File;
import java.util.Collections;
import java.util.List;

public class bjuy
  extends bjxl
  implements View.OnClickListener, bjva, bjvd
{
  public static final String a;
  private ViewStub jdField_a_of_type_AndroidViewViewStub;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private bjuz jdField_a_of_type_Bjuz;
  
  static
  {
    jdField_a_of_type_JavaLangString = ssf.e;
  }
  
  public bjuy(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private void a(String paramString)
  {
    paramString = new File(paramString);
    boolean bool;
    if (paramString.isFile())
    {
      bool = paramString.delete();
      ved.d("Q.qqstory.publish.edit.EditVideoAt", "delete file : " + bool);
    }
    if (!paramString.exists())
    {
      bool = paramString.mkdirs();
      ved.d("Q.qqstory.publish.edit.EditVideoAt", "create folder : " + bool);
    }
  }
  
  private void d()
  {
    Intent localIntent = new Intent(BaseApplication.getContext(), ForwardFriendListActivity.class);
    localIntent.putExtra("extra_choose_friend", 4);
    localIntent.putExtra("extra_left_btn_text", ajya.a(2131703915));
    a().getActivity().startActivityForResult(localIntent, 2);
    a().getActivity().overridePendingTransition(2130771997, 2130771977);
  }
  
  public JobSegment<bkld, bkld> a(int paramInt)
  {
    return new bklc(this.jdField_a_of_type_Bjuz, null, this.jdField_a_of_type_Bjuz.a(paramInt));
  }
  
  @NonNull
  public List<String> a(int paramInt)
  {
    if (paramInt < 0) {
      return Collections.EMPTY_LIST;
    }
    return this.jdField_a_of_type_Bjuz.a(paramInt);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)a(2131362835));
    if (this.jdField_a_of_type_AndroidWidgetRelativeLayout == null) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewStub.inflate());
    }
    if (this.jdField_a_of_type_Bjuz == null) {
      this.jdField_a_of_type_Bjuz = new bjuz(a(), this.jdField_a_of_type_AndroidWidgetRelativeLayout);
    }
    this.jdField_a_of_type_Bjuz.a(this);
    a(jdField_a_of_type_JavaLangString);
    a(bjvd.class, this);
  }
  
  public void a(int paramInt)
  {
    ved.b("Q.qqstory.publish.edit.EditVideoAt", "EditVideoAt onStateChanged state = %d.", Integer.valueOf(paramInt));
    this.jdField_a_of_type_Bjxn.a(paramInt);
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    switch (paramInt1)
    {
    default: 
      return;
    }
    a().getActivity();
    if (paramInt2 != -1)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAt", "the resultCode of choosing a qq single friend is not RESULT_OK!");
      this.jdField_a_of_type_Bjxn.a(0);
      return;
    }
    if (paramIntent == null)
    {
      ved.e("Q.qqstory.publish.edit.EditVideoAt", "the intent of choosing a single qq friend is null!");
      this.jdField_a_of_type_Bjxn.a(0);
      return;
    }
    String str2 = paramIntent.getStringExtra("extra_choose_friend_uin");
    String str1 = paramIntent.getStringExtra("extra_choose_friend_name");
    Object localObject = paramIntent.getStringExtra("extraChooseFriendRemark");
    if (str2 == null) {
      ved.c("Q.qqstory.publish.edit.EditVideoAt", "choose a single qq friend. result null");
    }
    for (;;)
    {
      this.jdField_a_of_type_Bjxn.a(0);
      return;
      ved.b("Q.qqstory.publish.edit.EditVideoAt", "choose a single qq friend. uin = %s name = %s remark = %s.", str2, str1, localObject);
      vei.a("video_edit", "list_alt", 0, 0, new String[0]);
      paramIntent = (Intent)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoAt", "remark is null. set remark to name.");
        paramIntent = str1;
      }
      localObject = str1;
      if (TextUtils.equals(str2, str1))
      {
        ved.d("Q.qqstory.publish.edit.EditVideoAt", "remark is null(choose a friend by searching.). set name to remark.");
        localObject = paramIntent;
      }
      this.jdField_a_of_type_Bjuz.a(str2, paramIntent, (String)localObject);
    }
  }
  
  public void a(int paramInt, @NonNull bkld parambkld)
  {
    super.a(paramInt, parambkld);
    paramInt = this.jdField_a_of_type_Bjuz.a(paramInt);
    if (paramInt > 0) {
      vei.a("video_edit", "send_alt", 0, 0, new String[] { paramInt + "" });
    }
  }
  
  protected boolean a(Message paramMessage)
  {
    if (paramMessage.what == 6)
    {
      int i = paramMessage.arg2;
      this.jdField_a_of_type_Bjuz.a(i);
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      if (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      return;
    case 18: 
      d();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(4);
  }
  
  public void g()
  {
    super.g();
    if (this.jdField_a_of_type_Bjuz != null) {
      this.jdField_a_of_type_Bjuz.b();
    }
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjuy
 * JD-Core Version:    0.7.0.1
 */