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

public class awqs
  extends awsa
{
  private awqw a;
  protected Set<String> a;
  
  public awqs(baxy parambaxy)
  {
    super(parambaxy);
  }
  
  public awqs(baxy parambaxy, awqw paramawqw)
  {
    super(parambaxy);
    this.jdField_a_of_type_Awqw = paramawqw;
  }
  
  public awqs(baxy parambaxy, awqw paramawqw, Set<String> paramSet)
  {
    super(parambaxy);
    this.jdField_a_of_type_Awqw = paramawqw;
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
  
  public void a(awoi paramawoi, awwr paramawwr, Bitmap paramBitmap)
  {
    if (paramawoi.c() == 103)
    {
      if (paramawwr.b() != null) {
        paramawwr.b().setImageDrawable(awwa.a(paramBitmap));
      }
      return;
    }
    super.a(paramawoi, paramawwr, paramBitmap);
  }
  
  public void b(awoi paramawoi, awwr paramawwr)
  {
    super.b(paramawoi, paramawwr);
    Object localObject;
    if (((paramawoi instanceof awnc)) && (paramawoi.c() == null))
    {
      if (paramawwr.c() != null) {
        paramawwr.c().setVisibility(8);
      }
      if (paramawwr.a() != null) {
        paramawwr.a().setVisibility(8);
      }
      if (paramawwr.b() != null) {
        paramawwr.b().setVisibility(8);
      }
      localObject = ((awwl)paramawwr).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(paramawoi.a());
      }
      localObject = paramawwr.a().findViewById(2131378332);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((paramawoi instanceof awmx)) || ((paramawoi instanceof awnb)) || ((paramawoi instanceof awmt))) && (awiw.a(paramawoi.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (paramawwr.c() != null)
      {
        localObject = paramawoi.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          paramawwr.c().setText(ajya.a(2131702578));
        }
      }
      if ((awwa.a) && (paramawwr.a() != null) && ((paramawoi instanceof awoe))) {
        paramawwr.a().setOnLongClickListener(new awqt(this, paramawoi));
      }
      if ((paramawwr.a() != null) && ((paramawoi instanceof awmt)))
      {
        int i = ((awmt)paramawoi).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          paramawwr = paramawwr.a();
          paramawwr.setContentDescription(paramawwr.getContext().getString(2131699373));
          paramawwr.setImageResource(2130845176);
          paramawwr.setOnClickListener(new awqu(this, paramawoi));
        }
      }
      return;
    }
    if ((paramawwr.c() != null) && (!TextUtils.isEmpty(paramawoi.c())))
    {
      paramawwr.c().setVisibility(0);
      label411:
      if (paramawwr.a() != null) {
        paramawwr.a().setVisibility(0);
      }
      if ((paramawwr.b() == null) || (paramawoi.b() == null)) {
        break label667;
      }
      paramawwr.b().setVisibility(0);
      if ((!(paramawoi instanceof awmt)) && (!(paramawoi instanceof awms)) && (!(paramawoi instanceof awmz))) {
        break label651;
      }
      localObject = paramawoi.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bbbr.b((String)localObject))) {
        break label635;
      }
      localObject = paramawwr.b().getContext().getResources().getDrawable(2130841310);
      ((Drawable)localObject).setBounds(0, 0, actj.a(15.0F, paramawwr.b().getContext().getResources()), actj.a(15.0F, paramawwr.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      paramawwr.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((awwl)paramawwr).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (paramawwr.c() == null) {
        break label411;
      }
      paramawwr.c().setVisibility(8);
      break label411;
      label635:
      paramawwr.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      paramawwr.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (paramawwr.b() != null) {
        paramawwr.b().setVisibility(8);
      }
    }
  }
  
  protected void c(awoi paramawoi, awwr paramawwr)
  {
    if (this.jdField_a_of_type_Awqw != null)
    {
      if (paramawwr.a() != null) {
        paramawwr.a().setOnClickListener(new awqv(this));
      }
      return;
    }
    super.c(paramawoi, paramawwr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awqs
 * JD-Core Version:    0.7.0.1
 */