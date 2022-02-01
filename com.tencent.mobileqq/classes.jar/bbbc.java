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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class bbbc
  extends bbck
{
  private bbbg a;
  protected Set<String> a;
  
  public bbbc(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public bbbc(FaceDecoder paramFaceDecoder, bbbg parambbbg)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bbbg = parambbbg;
  }
  
  public bbbc(FaceDecoder paramFaceDecoder, bbbg parambbbg, Set<String> paramSet)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bbbg = parambbbg;
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
    localArrayList.add(SelectMemberActivity.constructAResultRecord(paramString, "", 0, paramString));
    localIntent.putExtra("param_selected_records_for_create_discussion", localArrayList);
    paramActivity.startActivityForResult(localIntent, 1300);
  }
  
  public void a(bayt parambayt, bbhb parambbhb, Bitmap paramBitmap)
  {
    if (parambayt.c() == 103)
    {
      if (parambbhb.b() != null) {
        parambbhb.b().setImageDrawable(bbgk.a(paramBitmap));
      }
      return;
    }
    super.a(parambayt, parambbhb, paramBitmap);
  }
  
  public void b(bayt parambayt, bbhb parambbhb)
  {
    super.b(parambayt, parambbhb);
    Object localObject;
    if (((parambayt instanceof baxn)) && (parambayt.c() == null))
    {
      if (parambbhb.c() != null) {
        parambbhb.c().setVisibility(8);
      }
      if (parambbhb.a() != null) {
        parambbhb.a().setVisibility(8);
      }
      if (parambbhb.b() != null) {
        parambbhb.b().setVisibility(8);
      }
      localObject = ((bbgv)parambbhb).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(parambayt.a());
      }
      localObject = parambbhb.a().findViewById(2131379811);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((parambayt instanceof baxi)) || ((parambayt instanceof baxm)) || ((parambayt instanceof baxe))) && (batb.a(parambayt.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (parambbhb.c() != null)
      {
        localObject = parambayt.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          parambbhb.c().setText(amtj.a(2131701711));
        }
      }
      if ((bbgk.a) && (parambbhb.a() != null) && ((parambayt instanceof bayp))) {
        parambbhb.a().setOnLongClickListener(new bbbd(this, parambayt));
      }
      if ((parambbhb.a() != null) && ((parambayt instanceof baxe)))
      {
        int i = ((baxe)parambayt).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          parambbhb = parambbhb.a();
          parambbhb.setContentDescription(parambbhb.getContext().getString(2131698493));
          parambbhb.setImageResource(2130845928);
          parambbhb.setOnClickListener(new bbbe(this, parambayt));
        }
      }
      return;
    }
    if ((parambbhb.c() != null) && (!TextUtils.isEmpty(parambayt.c())))
    {
      parambbhb.c().setVisibility(0);
      label411:
      if (parambbhb.a() != null) {
        parambbhb.a().setVisibility(0);
      }
      if ((parambbhb.b() == null) || (parambayt.b() == null)) {
        break label667;
      }
      parambbhb.b().setVisibility(0);
      if ((!(parambayt instanceof baxe)) && (!(parambayt instanceof baxd)) && (!(parambayt instanceof baxk))) {
        break label651;
      }
      localObject = parambayt.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bftf.b((String)localObject))) {
        break label635;
      }
      localObject = parambbhb.b().getContext().getResources().getDrawable(2130841793);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(15.0F, parambbhb.b().getContext().getResources()), AIOUtils.dp2px(15.0F, parambbhb.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      parambbhb.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((bbgv)parambbhb).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (parambbhb.c() == null) {
        break label411;
      }
      parambbhb.c().setVisibility(8);
      break label411;
      label635:
      parambbhb.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      parambbhb.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (parambbhb.b() != null) {
        parambbhb.b().setVisibility(8);
      }
    }
  }
  
  protected void c(bayt parambayt, bbhb parambbhb)
  {
    if (this.jdField_a_of_type_Bbbg != null)
    {
      if (parambbhb.a() != null) {
        parambbhb.a().setOnClickListener(new bbbf(this));
      }
      return;
    }
    super.c(parambayt, parambbhb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbbc
 * JD-Core Version:    0.7.0.1
 */