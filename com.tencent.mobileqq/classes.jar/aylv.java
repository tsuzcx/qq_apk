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

public class aylv
  extends aynd
{
  private aylz a;
  protected Set<String> a;
  
  public aylv(bcws parambcws)
  {
    super(parambcws);
  }
  
  public aylv(bcws parambcws, aylz paramaylz)
  {
    super(parambcws);
    this.jdField_a_of_type_Aylz = paramaylz;
  }
  
  public aylv(bcws parambcws, aylz paramaylz, Set<String> paramSet)
  {
    super(parambcws);
    this.jdField_a_of_type_Aylz = paramaylz;
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
  
  public void a(ayjl paramayjl, ayru paramayru, Bitmap paramBitmap)
  {
    if (paramayjl.c() == 103)
    {
      if (paramayru.b() != null) {
        paramayru.b().setImageDrawable(ayrd.a(paramBitmap));
      }
      return;
    }
    super.a(paramayjl, paramayru, paramBitmap);
  }
  
  public void b(ayjl paramayjl, ayru paramayru)
  {
    super.b(paramayjl, paramayru);
    Object localObject;
    if (((paramayjl instanceof ayif)) && (paramayjl.c() == null))
    {
      if (paramayru.c() != null) {
        paramayru.c().setVisibility(8);
      }
      if (paramayru.a() != null) {
        paramayru.a().setVisibility(8);
      }
      if (paramayru.b() != null) {
        paramayru.b().setVisibility(8);
      }
      localObject = ((ayro)paramayru).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramayjl.a());
      }
      localObject = paramayru.a().findViewById(2131378922);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramayjl instanceof ayia)) || ((paramayjl instanceof ayie)) || ((paramayjl instanceof ayhw))) && (aydw.a(paramayjl.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramayru.c() != null)
      {
        localObject = paramayjl.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramayru.c().setText(alpo.a(2131702950));
        }
      }
      if ((ayrd.a) && (paramayru.a() != null) && ((paramayjl instanceof ayjh))) {
        paramayru.a().setOnLongClickListener(new aylw(this, paramayjl));
      }
      if ((paramayru.a() != null) && ((paramayjl instanceof ayhw)))
      {
        int i = ((ayhw)paramayjl).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramayru = paramayru.a();
          paramayru.setContentDescription(paramayru.getContext().getString(2131699724));
          paramayru.setImageResource(2130845541);
          paramayru.setOnClickListener(new aylx(this, paramayjl));
        }
      }
      return;
    }
    if ((paramayru.c() != null) && (!TextUtils.isEmpty(paramayjl.c())))
    {
      paramayru.c().setVisibility(0);
      label411:
      if (paramayru.a() != null) {
        paramayru.a().setVisibility(0);
      }
      if ((paramayru.b() == null) || (paramayjl.b() == null)) {
        break label667;
      }
      paramayru.b().setVisibility(0);
      if ((!(paramayjl instanceof ayhw)) && (!(paramayjl instanceof ayhv)) && (!(paramayjl instanceof ayic))) {
        break label651;
      }
      localObject = paramayjl.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bdal.b((String)localObject))) {
        break label635;
      }
      localObject = paramayru.b().getContext().getResources().getDrawable(2130841431);
      ((Drawable)localObject).setBounds(0, 0, aekt.a(15.0F, paramayru.b().getContext().getResources()), aekt.a(15.0F, paramayru.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramayru.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((ayro)paramayru).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramayru.c() == null) {
        break label411;
      }
      paramayru.c().setVisibility(8);
      break label411;
      label635:
      paramayru.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramayru.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramayru.b() != null) {
        paramayru.b().setVisibility(8);
      }
    }
  }
  
  protected void c(ayjl paramayjl, ayru paramayru)
  {
    if (this.jdField_a_of_type_Aylz != null)
    {
      if (paramayru.a() != null) {
        paramayru.a().setOnClickListener(new ayly(this));
      }
      return;
    }
    super.c(paramayjl, paramayru);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aylv
 * JD-Core Version:    0.7.0.1
 */