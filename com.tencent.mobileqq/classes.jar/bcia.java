import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class bcia
  extends bcji
{
  private bcie a;
  protected Set<String> a;
  
  public bcia(aoof paramaoof)
  {
    super(paramaoof);
  }
  
  public bcia(aoof paramaoof, bcie parambcie)
  {
    super(paramaoof);
    this.jdField_a_of_type_Bcie = parambcie;
  }
  
  public bcia(aoof paramaoof, bcie parambcie, Set<String> paramSet)
  {
    super(paramaoof);
    this.jdField_a_of_type_Bcie = parambcie;
    this.jdField_a_of_type_JavaUtilSet = paramSet;
  }
  
  private void a(Activity paramActivity, String paramString)
  {
    Intent localIntent = new Intent(paramActivity, SelectMemberActivity.class);
    localIntent.putExtra("param_type", 3000);
    localIntent.putExtra("param_subtype", 0);
    localIntent.putExtra("param_from", 1002);
    localIntent.putExtra("param_max", 99);
    localIntent.putExtra("param_entrance", 29);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(SelectMemberActivity.a(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    paramActivity.startActivityForResult(localIntent, 1300);
  }
  
  public void a(bcfr parambcfr, bcnz parambcnz, Bitmap paramBitmap)
  {
    if (parambcfr.c() == 103)
    {
      if (parambcnz.b() != null) {
        parambcnz.b().setImageDrawable(bcni.a(paramBitmap));
      }
      return;
    }
    super.a(parambcfr, parambcnz, paramBitmap);
  }
  
  public void b(bcfr parambcfr, bcnz parambcnz)
  {
    super.b(parambcfr, parambcnz);
    Object localObject;
    if (((parambcfr instanceof bcel)) && (parambcfr.c() == null))
    {
      if (parambcnz.c() != null) {
        parambcnz.c().setVisibility(8);
      }
      if (parambcnz.a() != null) {
        parambcnz.a().setVisibility(8);
      }
      if (parambcnz.b() != null) {
        parambcnz.b().setVisibility(8);
      }
      localObject = ((bcnt)parambcnz).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(parambcfr.a());
      }
      localObject = parambcnz.a().findViewById(2131380059);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((parambcfr instanceof bceg)) || ((parambcfr instanceof bcek)) || ((parambcfr instanceof bcec))) && (bbzx.a(parambcfr.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (parambcnz.c() != null)
      {
        localObject = parambcfr.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          parambcnz.c().setText(anzj.a(2131701476));
        }
      }
      if ((bcni.a) && (parambcnz.a() != null) && ((parambcfr instanceof bcfn))) {
        parambcnz.a().setOnLongClickListener(new bcib(this, parambcfr));
      }
      if ((parambcnz.a() != null) && ((parambcfr instanceof bcec)))
      {
        int i = ((bcec)parambcfr).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          parambcnz = parambcnz.a();
          parambcnz.setContentDescription(parambcnz.getContext().getString(2131698324));
          parambcnz.setImageResource(2130846028);
          parambcnz.setOnClickListener(new bcic(this, parambcfr));
        }
      }
      return;
    }
    if ((parambcnz.c() != null) && (!TextUtils.isEmpty(parambcfr.c())))
    {
      parambcnz.c().setVisibility(0);
      label411:
      if (parambcnz.a() != null) {
        parambcnz.a().setVisibility(0);
      }
      if ((parambcnz.b() == null) || (parambcfr.b() == null)) {
        break label667;
      }
      parambcnz.b().setVisibility(0);
      if ((!(parambcfr instanceof bcec)) && (!(parambcfr instanceof bceb)) && (!(parambcfr instanceof bcei))) {
        break label651;
      }
      localObject = parambcfr.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bhjx.b((String)localObject))) {
        break label635;
      }
      localObject = parambcnz.b().getContext().getResources().getDrawable(2130841751);
      ((Drawable)localObject).setBounds(0, 0, agej.a(15.0F, parambcnz.b().getContext().getResources()), agej.a(15.0F, parambcnz.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      parambcnz.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((bcnt)parambcnz).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (parambcnz.c() == null) {
        break label411;
      }
      parambcnz.c().setVisibility(8);
      break label411;
      label635:
      parambcnz.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      parambcnz.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (parambcnz.b() != null) {
        parambcnz.b().setVisibility(8);
      }
    }
  }
  
  protected void c(bcfr parambcfr, bcnz parambcnz)
  {
    if (this.jdField_a_of_type_Bcie != null)
    {
      if (parambcnz.a() != null) {
        parambcnz.a().setOnClickListener(new bcid(this));
      }
      return;
    }
    super.c(parambcfr, parambcnz);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcia
 * JD-Core Version:    0.7.0.1
 */