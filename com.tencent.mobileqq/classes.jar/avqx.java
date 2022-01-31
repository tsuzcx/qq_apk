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

public class avqx
  extends avsf
{
  private avrb a;
  protected Set<String> a;
  
  public avqx(azwg paramazwg)
  {
    super(paramazwg);
  }
  
  public avqx(azwg paramazwg, avrb paramavrb)
  {
    super(paramazwg);
    this.jdField_a_of_type_Avrb = paramavrb;
  }
  
  public avqx(azwg paramazwg, avrb paramavrb, Set<String> paramSet)
  {
    super(paramazwg);
    this.jdField_a_of_type_Avrb = paramavrb;
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
  
  public void a(avon paramavon, avww paramavww, Bitmap paramBitmap)
  {
    if (paramavon.c() == 103)
    {
      if (paramavww.b() != null) {
        paramavww.b().setImageDrawable(avwf.a(paramBitmap));
      }
      return;
    }
    super.a(paramavon, paramavww, paramBitmap);
  }
  
  public void b(avon paramavon, avww paramavww)
  {
    super.b(paramavon, paramavww);
    Object localObject;
    if (((paramavon instanceof avnh)) && (paramavon.c() == null))
    {
      if (paramavww.c() != null) {
        paramavww.c().setVisibility(8);
      }
      if (paramavww.a() != null) {
        paramavww.a().setVisibility(8);
      }
      if (paramavww.b() != null) {
        paramavww.b().setVisibility(8);
      }
      localObject = ((avwq)paramavww).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramavon.a());
      }
      localObject = paramavww.a().findViewById(2131312503);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramavon instanceof avnc)) || ((paramavon instanceof avng)) || ((paramavon instanceof avmy))) && (avjb.a(paramavon.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramavww.c() != null)
      {
        localObject = paramavon.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramavww.c().setText(ajjy.a(2131636783));
        }
      }
      if ((avwf.a) && (paramavww.a() != null) && ((paramavon instanceof avoj))) {
        paramavww.a().setOnLongClickListener(new avqy(this, paramavon));
      }
      if ((paramavww.a() != null) && ((paramavon instanceof avmy)))
      {
        int i = ((avmy)paramavon).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramavww = paramavww.a();
          paramavww.setContentDescription(paramavww.getContext().getString(2131633596));
          paramavww.setImageResource(2130845091);
          paramavww.setOnClickListener(new avqz(this, paramavon));
        }
      }
      return;
    }
    if ((paramavww.c() != null) && (!TextUtils.isEmpty(paramavon.c())))
    {
      paramavww.c().setVisibility(0);
      label411:
      if (paramavww.a() != null) {
        paramavww.a().setVisibility(0);
      }
      if ((paramavww.b() == null) || (paramavon.b() == null)) {
        break label667;
      }
      paramavww.b().setVisibility(0);
      if ((!(paramavon instanceof avmy)) && (!(paramavon instanceof avmx)) && (!(paramavon instanceof avne))) {
        break label651;
      }
      localObject = paramavon.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!azzz.b((String)localObject))) {
        break label635;
      }
      localObject = paramavww.b().getContext().getResources().getDrawable(2130841234);
      ((Drawable)localObject).setBounds(0, 0, aciy.a(15.0F, paramavww.b().getContext().getResources()), aciy.a(15.0F, paramavww.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramavww.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((avwq)paramavww).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramavww.c() == null) {
        break label411;
      }
      paramavww.c().setVisibility(8);
      break label411;
      label635:
      paramavww.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramavww.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramavww.b() != null) {
        paramavww.b().setVisibility(8);
      }
    }
  }
  
  protected void c(avon paramavon, avww paramavww)
  {
    if (this.jdField_a_of_type_Avrb != null)
    {
      if (paramavww.a() != null) {
        paramavww.a().setOnClickListener(new avra(this));
      }
      return;
    }
    super.c(paramavon, paramavww);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avqx
 * JD-Core Version:    0.7.0.1
 */