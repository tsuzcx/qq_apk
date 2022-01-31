import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tribe.async.async.JobSegment;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditTakeVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class bmul
  extends bmiv
  implements DialogInterface.OnDismissListener, bmei
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bmuo jdField_a_of_type_Bmuo;
  @Nullable
  private bmur jdField_a_of_type_Bmur;
  private float b;
  private float c;
  private float d;
  
  public bmul(@NonNull bmix parambmix)
  {
    super(parambmix);
  }
  
  private String a(bmur parambmur)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bmmf localbmmf = (bmmf)a().a();
      if (localbmmf == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambmur = new JSONArray(Arrays.asList(parambmur.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambmur);
        parambmur = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xod.a(a())), Integer.valueOf(xod.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmf.u * localbmmf.q), Float.valueOf(localbmmf.v * localbmmf.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmmf.b.x + localbmmf.s), Float.valueOf(localbmmf.b.y + localbmmf.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambmur);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbmmf.r);
        localJSONObject1.put("a", localJSONObject2);
        parambmur = localJSONObject1.toString();
        return parambmur;
      }
      catch (JSONException parambmur)
      {
        wsv.e("Q.qqstory.publish.editEditVideoInteract", parambmur.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bmuo != null) && (this.jdField_a_of_type_Bmuo.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bmuo = new bmuo(a(), this, paramInt);
    this.jdField_a_of_type_Bmuo.a(a());
    this.jdField_a_of_type_Bmuo.setContentView(2131561632);
    this.jdField_a_of_type_Bmuo.setOnDismissListener(this);
    this.jdField_a_of_type_Bmuo.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bmuo != null) && (this.jdField_a_of_type_Bmuo.isShowing()))
    {
      this.jdField_a_of_type_Bmuo.dismiss();
      this.jdField_a_of_type_Bmuo = null;
    }
  }
  
  public Bitmap a()
  {
    bmme localbmme = a();
    if (localbmme.a()) {}
    for (;;)
    {
      return null;
      int i = localbmme.a.width();
      int j = localbmme.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbmme.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        wsv.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bmme a()
  {
    Object localObject = (bmee)a(bmee.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bmee)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bmur a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bmur;
  }
  
  public JobSegment<bmwn, bmwn> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bmix.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bmix.a.a instanceof EditLocalVideoSource))) {
      return new bmwz(this);
    }
    return new bmwr(this);
  }
  
  public void a()
  {
    super.a();
    a(bmei.class, this);
  }
  
  public void a(int paramInt, bmur parambmur)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambmur.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambmur.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambmur.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bmur = parambmur;
    }
  }
  
  public void a(Bundle paramBundle, bmur parambmur)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambmur);
  }
  
  public void a(bmmf parambmmf, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bmki.a(localBundle, parambmmf);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmix.a(38, localBundle);
    parambmmf.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bmur = new bmur(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bmuo != null) && (this.jdField_a_of_type_Bmuo.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bmwn parambmwn)
  {
    bmur localbmur = a();
    if (localbmur != null)
    {
      ((blnu)blmf.a(15)).a(null);
      String str = a(localbmur);
      if (!TextUtils.isEmpty(str))
      {
        wsv.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambmwn.a.putExtra("i_l", str);
        wta.a("video_edit", "pub_vote", 2, 0, new String[] { localbmur.jdField_a_of_type_ArrayOfJavaLangString[0] });
        wta.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    wsv.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
  }
  
  public void a_(int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      d();
      return;
    }
    int i = -1;
    paramInt = i;
    if (paramObject != null)
    {
      paramInt = i;
      if ((paramObject instanceof Bundle))
      {
        paramObject = (Bundle)paramObject;
        this.jdField_a_of_type_Float = paramObject.getFloat("scale");
        this.b = paramObject.getFloat("rotate");
        this.c = paramObject.getFloat("translateX");
        this.d = paramObject.getFloat("translateY");
        paramInt = paramObject.getInt("interact_type");
      }
    }
    if (paramInt != 1001) {
      throw new IllegalArgumentException("unSupport paster type:" + paramInt);
    }
    a(paramInt);
    a().e();
    wta.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      wsv.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bmur = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bmur localbmur = a();
    if (localbmur == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbmur.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbmur.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbmur.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bdcd.a(a(), 230, alpo.a(2131704170), null, alpo.a(2131704234), alpo.a(2131704190), new bmum(this), new bmun(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmix.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmul
 * JD-Core Version:    0.7.0.1
 */