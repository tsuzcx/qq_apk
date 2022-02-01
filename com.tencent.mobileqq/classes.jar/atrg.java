import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.view.View;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchGroupFragment;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class atrg
  extends atrb
{
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CharSequence b;
  
  public atrg(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aufn.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    localStringBuilder.append(FileUtil.filesizeToString(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  public CharSequence a()
  {
    return bcnc.a(((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)).d().toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  public List<bcfj> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramContext.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramContext.next();
      atrg localatrg = new atrg(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localatrg.a(this.jdField_a_of_type_AndroidOsBundle);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileInfo);
      localatrg.a(localArrayList);
      paramQQAppInterface.add(localatrg);
    }
    return paramQQAppInterface;
  }
  
  public void a(List<FileInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    }
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
    Object localObject = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    paramView = (BaseActivity)paramView.getContext();
    localObject = auea.a((FileInfo)localObject);
    paramView = new atyk(paramView, new atyi(paramView.app, paramView, (FileManagerEntity)localObject, 10000));
    paramView.a(8);
    paramView.a();
  }
  
  public boolean b()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return atpm.a(localFileInfo);
    }
    return false;
  }
  
  public int c()
  {
    return 0;
  }
  
  public CharSequence c()
  {
    Object localObject;
    if (this.jdField_a_of_type_JavaLangCharSequence == null)
    {
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label61;
      }
      localObject = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      localObject = new SpannableStringBuilder();
      ((SpannableStringBuilder)localObject).append(d());
    }
    label61:
    for (this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);; this.jdField_a_of_type_JavaLangCharSequence = d()) {
      return this.jdField_a_of_type_JavaLangCharSequence;
    }
  }
  
  public String c()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null)
    {
      int i = auea.a(localFileInfo.c());
      if ((i == 0) || (i == 2) || (i == 5)) {
        return localFileInfo.c();
      }
    }
    return "";
  }
  
  protected void c(View paramView)
  {
    paramView = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (atpm.a(paramView)) {
      atpm.b(paramView);
    }
    for (;;)
    {
      if (!FileUtil.fileExistsAndNotEmpty(paramView.c()))
      {
        audr.a(auea.d(paramView.d()) + anvx.a(2131709082));
        atpm.b(paramView);
      }
      return;
      atpm.a(paramView);
      bdla.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
    }
  }
  
  public int d()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public CharSequence d()
  {
    if (this.b != null) {
      return this.b;
    }
    int i = this.jdField_a_of_type_JavaUtilList.size();
    if (i > 1)
    {
      localSpannableStringBuilder = new SpannableStringBuilder(i + anvx.a(2131703988) + "\"");
      localSpannableStringBuilder.append(bcnc.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      localSpannableStringBuilder.append("\"").append(anvx.a(2131692269));
      this.b = localSpannableStringBuilder;
      return this.b;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(bcnc.a(a((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)), this.jdField_a_of_type_JavaLangString));
    if (this.b == null) {
      this.b = localSpannableStringBuilder;
    }
    return this.b;
  }
  
  public String d()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return localFileInfo.d();
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
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return auea.a(localFileInfo.c());
    }
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atrg
 * JD-Core Version:    0.7.0.1
 */