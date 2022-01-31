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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aqzd
  extends aqyy
{
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private List<FileInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  private CharSequence b;
  
  public aqzd(String paramString, int paramInt)
  {
    super(paramString, paramInt);
  }
  
  private String a(FileInfo paramFileInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(aroy.b(paramFileInfo.b()));
    localStringBuilder.append("  ");
    localStringBuilder.append(arof.a(paramFileInfo.a()));
    return localStringBuilder.toString();
  }
  
  public CharSequence a()
  {
    return ayrd.a(((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)).d().toLowerCase(), this.jdField_a_of_type_JavaLangString);
  }
  
  public List<ayjl> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    paramQQAppInterface = new ArrayList();
    paramContext = this.jdField_a_of_type_JavaUtilList.iterator();
    while (paramContext.hasNext())
    {
      FileInfo localFileInfo = (FileInfo)paramContext.next();
      aqzd localaqzd = new aqzd(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
      localaqzd.a(this.jdField_a_of_type_AndroidOsBundle);
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localFileInfo);
      localaqzd.a(localArrayList);
      paramQQAppInterface.add(localaqzd);
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
    localObject = arni.a((FileInfo)localObject);
    paramView = new arhj(paramView, new arhh(paramView.app, paramView, (FileManagerEntity)localObject, 10000));
    paramView.a(8);
    paramView.a();
  }
  
  public boolean b()
  {
    FileInfo localFileInfo = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (localFileInfo != null) {
      return aqxj.a(localFileInfo);
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
      int i = arni.a(localFileInfo.c());
      if ((i == 0) || (i == 2) || (i == 5)) {
        return localFileInfo.c();
      }
    }
    return "";
  }
  
  protected void c(View paramView)
  {
    paramView = (FileInfo)this.jdField_a_of_type_JavaUtilList.get(0);
    if (aqxj.a(paramView)) {
      aqxj.b(paramView);
    }
    for (;;)
    {
      if (!arof.b(paramView.c()))
      {
        armz.a(arni.d(paramView.d()) + alpo.a(2131710006));
        aqxj.b(paramView);
      }
      return;
      aqxj.a(paramView);
      azmj.b(null, "dc00898", "", "", "0X800AA91", "0X800AA91", 2, 0, "0", "0", "", "");
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
      localSpannableStringBuilder = new SpannableStringBuilder(i + alpo.a(2131704891) + "\"");
      localSpannableStringBuilder.append(ayrd.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString));
      localSpannableStringBuilder.append("\"").append(alpo.a(2131692539));
      this.b = localSpannableStringBuilder;
      return this.b;
    }
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    localSpannableStringBuilder.append(ayrd.a(a((FileInfo)this.jdField_a_of_type_JavaUtilList.get(0)), this.jdField_a_of_type_JavaLangString));
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
      return arni.a(localFileInfo.c());
    }
    return 11;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqzd
 * JD-Core Version:    0.7.0.1
 */