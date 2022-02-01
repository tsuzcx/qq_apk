import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class auas
  extends aual
{
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FileManagerEntity> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private String jdField_b_of_type_JavaLangString;
  
  public auas(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  public CharSequence a()
  {
    return bcni.a(((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).fileName.toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  public List<bcfr> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramContext.hasNext())
    {
      FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramContext.next();
      auas localauas = new auas(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localauas.a(this.jdField_a_of_type_AndroidOsBundle);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileManagerEntity);
      localauas.a(localArrayList);
      paramQQAppInterface.add(localauas);
    }
    return paramQQAppInterface;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.jdField_a_of_type_AndroidOsBundle != null) {
      this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("qfile_search_param_ex_params_target_uin", "");
    }
  }
  
  public void a(List<FileManagerEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if ((!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (this.jdField_b_of_type_JavaLangString.equals(antf.z)))
      {
        ArrayList localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          FileManagerEntity localFileManagerEntity = (FileManagerEntity)paramList.next();
          if (!auoo.b(localFileManagerEntity)) {
            localArrayList.add(localFileManagerEntity);
          }
        }
        this.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
  }
  
  public CharSequence b()
  {
    return null;
  }
  
  public String b()
  {
    return null;
  }
  
  protected void b(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    paramView = (BaseActivity)paramView.getContext();
    if (localFileManagerEntity.nFileType == 13)
    {
      becb.a(localFileManagerEntity.Uuid, paramView, this.jdField_a_of_type_Int, localFileManagerEntity, paramView.app);
      return;
    }
    auhr localauhr = new auhr(paramView.app, paramView, localFileManagerEntity, 10001);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("from_qlink_enter_recent", false);
    localBundle.putString("c2c_discussion_recentfile", localFileManagerEntity.peerUin);
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localBundle.putString("file_browser_extra_params_uin", this.jdField_b_of_type_JavaLangString);
    }
    localauhr.a(localBundle);
    paramView = new auht(paramView, localauhr);
    paramView.a(7);
    if (this.jdField_a_of_type_Int != 0) {
      paramView.a(this.jdField_a_of_type_Int);
    }
    paramView.a(anzj.a(2131703403));
    paramView.a();
  }
  
  public boolean b()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null) {
      return atyw.a(localFileManagerEntity);
    }
    return false;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    Object localObject3;
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label157;
      }
      localObject3 = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
      localObject1 = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject1).append(d());
      if (((FileManagerEntity)localObject3).nFileType == 13) {
        break label87;
      }
      ((SpannableStringBuilder)localObject1).append(" ").append(aunj.c((FileManagerEntity)localObject3));
    }
    label87:
    Object localObject2;
    for (;;)
    {
      this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return this.jdField_a_of_type_JavaLangCharSequence;
      localObject2 = auoy.b(((FileManagerEntity)localObject3).srvTime);
      localObject3 = aunj.b((FileManagerEntity)localObject3);
      ((SpannableStringBuilder)localObject1).clear();
      ((SpannableStringBuilder)localObject1).append((String)localObject2 + " " + (String)localObject3 + " " + BaseApplicationImpl.getContext().getString(2131692100));
    }
    label157:
    Object localObject1 = this.jdField_a_of_type_JavaUtilList.iterator();
    long l = 0L;
    label169:
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (l >= ((FileManagerEntity)localObject2).srvTime) {
        break label219;
      }
      l = ((FileManagerEntity)localObject2).srvTime;
    }
    label219:
    for (;;)
    {
      break label169;
      this.jdField_a_of_type_JavaLangCharSequence = d();
      break;
    }
  }
  
  public String c()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    Object localObject1 = "";
    int i = aunj.a(localFileManagerEntity.fileName);
    if ((i == 0) || (i == 2))
    {
      Object localObject2 = localFileManagerEntity.strMiddleThumPath;
      localObject1 = localObject2;
      if (!auog.b((String)localObject2)) {
        localObject1 = localFileManagerEntity.strLargeThumPath;
      }
      localObject2 = localObject1;
      if (!auog.b((String)localObject1)) {
        localObject2 = localFileManagerEntity.strThumbPath;
      }
      localObject1 = localObject2;
      if (auog.b((String)localObject2)) {}
    }
    for (;;)
    {
      if (localFileManagerEntity.nFileType == 13) {
        localObject1 = becb.f(localFileManagerEntity.Uuid);
      }
      return localObject1;
      if (i == 5) {
        localObject1 = localFileManagerEntity.getFilePath();
      }
    }
  }
  
  protected void c(View paramView)
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    paramView = (BaseActivity)paramView.getContext();
    if (atyw.a(localFileManagerEntity)) {
      atyw.b(localFileManagerEntity);
    }
    for (;;)
    {
      if ((localFileManagerEntity.cloudType == 3) && (!auog.b(localFileManagerEntity.getFilePath())))
      {
        auna.a(aunj.d(localFileManagerEntity.fileName) + anzj.a(2131708493));
        atyw.b(localFileManagerEntity);
      }
      return;
      atyw.a(localFileManagerEntity);
      bdll.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 1, 0, "0", "0", "", "");
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public CharSequence d()
  {
    int i = 7;
    if (this.jdField_b_of_type_JavaLangCharSequence != null) {
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    Object localObject1;
    if (j > 1)
    {
      localObject1 = new SpannableStringBuilder(j + anzj.a(2131703407) + "\"");
      ((SpannableStringBuilder)localObject1).append(bcni.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      ((SpannableStringBuilder)localObject1).append("\"").append(anzj.a(2131692131));
      this.jdField_b_of_type_JavaLangCharSequence = ((CharSequence)localObject1);
      return this.jdField_b_of_type_JavaLangCharSequence;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    String str = aunj.b((FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0)).trim();
    if (str.indexOf(anzj.a(2131692122)) == 0) {
      localSpannableStringBuilder.append(anzj.a(2131692122) + " ");
    }
    for (;;)
    {
      localObject1 = str;
      if (i != 0) {}
      try
      {
        localObject1 = str.toLowerCase().substring(i);
        localSpannableStringBuilder.append(bcni.a((String)localObject1, this.jdField_a_of_type_JavaLangString));
        if (this.jdField_b_of_type_JavaLangCharSequence == null) {
          this.jdField_b_of_type_JavaLangCharSequence = localSpannableStringBuilder;
        }
        return this.jdField_b_of_type_JavaLangCharSequence;
        if (str.indexOf(anzj.a(2131692126)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692126) + " ");
        }
        else if (str.indexOf(anzj.a(2131692123)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692123) + " ");
          i = 4;
        }
        else if (str.indexOf(anzj.a(2131692127)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692127) + " ");
          i = 4;
        }
        else if (str.indexOf(anzj.a(2131692121)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692121) + " ");
          i = 2;
        }
        else if (str.indexOf(anzj.a(2131692125)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692125) + "  ");
          i = 2;
        }
        else if (str.indexOf(anzj.a(2131692124)) == 0)
        {
          localSpannableStringBuilder.append(anzj.a(2131692124));
          i = 2;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2 = str;
        }
        i = 0;
      }
    }
  }
  
  public String d()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null) {
      return localFileManagerEntity.fileName;
    }
    return "";
  }
  
  protected void d(View paramView)
  {
    paramView = (BaseActivity)paramView.getContext();
    FileSelectorSearchGroupFragment.a(this);
    Intent localIntent = new Intent();
    localIntent.putExtra("qfile_search_param_ex_params", this.jdField_a_of_type_AndroidOsBundle);
    PublicFragmentActivity.a(paramView, localIntent, FileSelectorSearchGroupFragment.class, 9999);
  }
  
  public int e()
  {
    FileManagerEntity localFileManagerEntity = (FileManagerEntity)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileManagerEntity != null)
    {
      if (localFileManagerEntity.nFileType == 13) {
        return 13;
      }
      return aunj.a(localFileManagerEntity.fileName);
    }
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auas
 * JD-Core Version:    0.7.0.1
 */