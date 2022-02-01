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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Set;

public class bchu
  extends bcjc
{
  private bchy a;
  protected Set<String> a;
  
  public bchu(FaceDecoder paramFaceDecoder)
  {
    super(paramFaceDecoder);
  }
  
  public bchu(FaceDecoder paramFaceDecoder, bchy parambchy)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bchy = parambchy;
  }
  
  public bchu(FaceDecoder paramFaceDecoder, bchy parambchy, Set<String> paramSet)
  {
    super(paramFaceDecoder);
    this.jdField_a_of_type_Bchy = parambchy;
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
  
  public void a(bcfj parambcfj, bcnt parambcnt, Bitmap paramBitmap)
  {
    if (parambcfj.c() == 103)
    {
      if (parambcnt.b() != null) {
        parambcnt.b().setImageDrawable(bcnc.a(paramBitmap));
      }
      return;
    }
    super.a(parambcfj, parambcnt, paramBitmap);
  }
  
  public void b(bcfj parambcfj, bcnt parambcnt)
  {
    super.b(parambcfj, parambcnt);
    Object localObject;
    if (((parambcfj instanceof bced)) && (parambcfj.c() == null))
    {
      if (parambcnt.c() != null) {
        parambcnt.c().setVisibility(8);
      }
      if (parambcnt.a() != null) {
        parambcnt.a().setVisibility(8);
      }
      if (parambcnt.b() != null) {
        parambcnt.b().setVisibility(8);
      }
      localObject = ((bcnn)parambcnt).e();
      if (localObject != null)
      {
        ((TextView)localObject).setVisibility(0);
        ((TextView)localObject).setText(parambcfj.a());
      }
      localObject = parambcnt.a().findViewById(2131380136);
      if (localObject != null)
      {
        ((View)localObject).setVisibility(8);
        if ((((parambcfj instanceof bcdy)) || ((parambcfj instanceof bcec)) || ((parambcfj instanceof bcdu))) && (bbzq.a(parambcfj.b()))) {
          ((View)localObject).setVisibility(0);
        }
      }
      if (parambcnt.c() != null)
      {
        localObject = parambcfj.b();
        if ((this.jdField_a_of_type_JavaUtilSet != null) && (this.jdField_a_of_type_JavaUtilSet.contains(localObject))) {
          parambcnt.c().setText(anvx.a(2131702062));
        }
      }
      if ((bcnc.a) && (parambcnt.a() != null) && ((parambcfj instanceof bcff))) {
        parambcnt.a().setOnLongClickListener(new bchv(this, parambcfj));
      }
      if ((parambcnt.a() != null) && ((parambcfj instanceof bcdu)))
      {
        int i = ((bcdu)parambcfj).f();
        if (QLog.isColorLevel()) {
          QLog.d("ContactSearchResultPresenter", 2, "add from type =" + i);
        }
        if ((i == 21) || (i == 1) || (i == 2))
        {
          parambcnt = parambcnt.a();
          parambcnt.setContentDescription(parambcnt.getContext().getString(2131698790));
          parambcnt.setImageResource(2130846016);
          parambcnt.setOnClickListener(new bchw(this, parambcfj));
        }
      }
      return;
    }
    if ((parambcnt.c() != null) && (!TextUtils.isEmpty(parambcfj.c())))
    {
      parambcnt.c().setVisibility(0);
      label411:
      if (parambcnt.a() != null) {
        parambcnt.a().setVisibility(0);
      }
      if ((parambcnt.b() == null) || (parambcfj.b() == null)) {
        break label667;
      }
      parambcnt.b().setVisibility(0);
      if ((!(parambcfj instanceof bcdu)) && (!(parambcfj instanceof bcdt)) && (!(parambcfj instanceof bcea))) {
        break label651;
      }
      localObject = parambcfj.b();
      if ((TextUtils.isEmpty((CharSequence)localObject)) || (!bhbx.b((String)localObject))) {
        break label635;
      }
      localObject = parambcnt.b().getContext().getResources().getDrawable(2130841803);
      ((Drawable)localObject).setBounds(0, 0, AIOUtils.dp2px(15.0F, parambcnt.b().getContext().getResources()), AIOUtils.dp2px(15.0F, parambcnt.b().getContext().getResources()));
      ThemeUtil.setThemeFilter((Drawable)localObject, ThemeUtil.curThemeId);
      parambcnt.b().setCompoundDrawables(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = ((bcnn)parambcnt).e();
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      break;
      if (parambcnt.c() == null) {
        break label411;
      }
      parambcnt.c().setVisibility(8);
      break label411;
      label635:
      parambcnt.b().setCompoundDrawables(null, null, null, null);
      continue;
      label651:
      parambcnt.b().setCompoundDrawables(null, null, null, null);
      continue;
      label667:
      if (parambcnt.b() != null) {
        parambcnt.b().setVisibility(8);
      }
    }
  }
  
  protected void c(bcfj parambcfj, bcnt parambcnt)
  {
    if (this.jdField_a_of_type_Bchy != null)
    {
      String str;
      if (parambcnt.a() != null)
      {
        if (!(parambcfj instanceof bcee)) {
          break label72;
        }
        str = ((bcee)parambcfj).a().getTroopName();
        if (!(parambcfj instanceof bcee)) {
          break label78;
        }
      }
      label72:
      label78:
      for (parambcfj = ((bcee)parambcfj).a().getTroopUin();; parambcfj = "")
      {
        parambcnt.a().setOnClickListener(new bchx(this, str, parambcfj));
        return;
        str = "";
        break;
      }
    }
    super.c(parambcfj, parambcnt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchu
 * JD-Core Version:    0.7.0.1
 */