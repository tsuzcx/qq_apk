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

public class bbph
  extends bbqp
{
  private bbpl a;
  protected Set<String> a;
  
  public bbph(aobu paramaobu)
  {
    super(paramaobu);
  }
  
  public bbph(aobu paramaobu, bbpl parambbpl)
  {
    super(paramaobu);
    this.jdField_a_of_type_Bbpl = parambbpl;
  }
  
  public bbph(aobu paramaobu, bbpl parambbpl, Set<String> paramSet)
  {
    super(paramaobu);
    this.jdField_a_of_type_Bbpl = parambbpl;
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
  
  public void a(bbmy parambbmy, bbvg parambbvg, Bitmap paramBitmap)
  {
    if (parambbmy.c() == 103)
    {
      if (parambbvg.b() != null) {
        parambbvg.b().setImageDrawable(bbup.a(paramBitmap));
      }
      return;
    }
    super.a(parambbmy, parambbvg, paramBitmap);
  }
  
  public void b(bbmy parambbmy, bbvg parambbvg)
  {
    super.b(parambbmy, parambbvg);
    Object localObject;
    if (((parambbmy instanceof bbls)) && (parambbmy.c() == null))
    {
      if (parambbvg.c() != null) {
        parambbvg.c().setVisibility(8);
      }
      if (parambbvg.a() != null) {
        parambbvg.a().setVisibility(8);
      }
      if (parambbvg.b() != null) {
        parambbvg.b().setVisibility(8);
      }
      localObject = ((bbva)parambbvg).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(parambbmy.a());
      }
      localObject = parambbvg.a().findViewById(2131379878);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((parambbmy instanceof bbln)) || ((parambbmy instanceof bblr)) || ((parambbmy instanceof bblj))) && (bbhd.a(parambbmy.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (parambbvg.c() != null)
      {
        localObject = parambbmy.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          parambbvg.c().setText(anni.a(2131701369));
        }
      }
      if ((bbup.a) && (parambbvg.a() != null) && ((parambbmy instanceof bbmu))) {
        parambbvg.a().setOnLongClickListener(new bbpi(this, parambbmy));
      }
      if ((parambbvg.a() != null) && ((parambbmy instanceof bblj)))
      {
        int i = ((bblj)parambbmy).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          parambbvg = parambbvg.a();
          parambbvg.setContentDescription(parambbvg.getContext().getString(2131698222));
          parambbvg.setImageResource(2130846013);
          parambbvg.setOnClickListener(new bbpj(this, parambbmy));
        }
      }
      return;
    }
    if ((parambbvg.c() != null) && (!TextUtils.isEmpty(parambbmy.c())))
    {
      parambbvg.c().setVisibility(0);
      label411:
      if (parambbvg.a() != null) {
        parambbvg.a().setVisibility(0);
      }
      if ((parambbvg.b() == null) || (parambbmy.b() == null)) {
        break label667;
      }
      parambbvg.b().setVisibility(0);
      if ((!(parambbmy instanceof bblj)) && (!(parambbmy instanceof bbli)) && (!(parambbmy instanceof bblp))) {
        break label651;
      }
      localObject = parambbmy.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bgjw.b((String)localObject))) {
        break label635;
      }
      localObject = parambbvg.b().getContext().getResources().getDrawable(2130841741);
      ((Drawable)localObject).setBounds(0, 0, afur.a(15.0F, parambbvg.b().getContext().getResources()), afur.a(15.0F, parambbvg.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      parambbvg.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((bbva)parambbvg).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (parambbvg.c() == null) {
        break label411;
      }
      parambbvg.c().setVisibility(8);
      break label411;
      label635:
      parambbvg.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      parambbvg.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (parambbvg.b() != null) {
        parambbvg.b().setVisibility(8);
      }
    }
  }
  
  protected void c(bbmy parambbmy, bbvg parambbvg)
  {
    if (this.jdField_a_of_type_Bbpl != null)
    {
      if (parambbvg.a() != null) {
        parambbvg.a().setOnClickListener(new bbpk(this));
      }
      return;
    }
    super.c(parambbmy, parambbvg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbph
 * JD-Core Version:    0.7.0.1
 */