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

public class bmyx
  extends bmnh
  implements DialogInterface.OnDismissListener, bmiu
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bmza jdField_a_of_type_Bmza;
  @Nullable
  private bmzd jdField_a_of_type_Bmzd;
  private float b;
  private float c;
  private float d;
  
  public bmyx(@NonNull bmnj parambmnj)
  {
    super(parambmnj);
  }
  
  private String a(bmzd parambmzd)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bmqr localbmqr = (bmqr)a().a();
      if (localbmqr == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambmzd = new JSONArray(Arrays.asList(parambmzd.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambmzd);
        parambmzd = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(xsm.a(a())), Integer.valueOf(xsm.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmqr.u * localbmqr.q), Float.valueOf(localbmqr.v * localbmqr.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbmqr.b.x + localbmqr.s), Float.valueOf(localbmqr.b.y + localbmqr.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambmzd);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbmqr.r);
        localJSONObject1.put("a", localJSONObject2);
        parambmzd = localJSONObject1.toString();
        return parambmzd;
      }
      catch (JSONException parambmzd)
      {
        wxe.e("Q.qqstory.publish.editEditVideoInteract", parambmzd.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bmza != null) && (this.jdField_a_of_type_Bmza.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bmza = new bmza(a(), this, paramInt);
    this.jdField_a_of_type_Bmza.a(a());
    this.jdField_a_of_type_Bmza.setContentView(2131561650);
    this.jdField_a_of_type_Bmza.setOnDismissListener(this);
    this.jdField_a_of_type_Bmza.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bmza != null) && (this.jdField_a_of_type_Bmza.isShowing()))
    {
      this.jdField_a_of_type_Bmza.dismiss();
      this.jdField_a_of_type_Bmza = null;
    }
  }
  
  public Bitmap a()
  {
    bmqq localbmqq = a();
    if (localbmqq.a()) {}
    for (;;)
    {
      return null;
      int i = localbmqq.a.width();
      int j = localbmqq.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbmqq.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        wxe.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bmqq a()
  {
    Object localObject = (bmiq)a(bmiq.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bmiq)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bmzd a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bmzd;
  }
  
  public JobSegment<bnaz, bnaz> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bmnj.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bmnj.a.a instanceof EditLocalVideoSource))) {
      return new bnbl(this);
    }
    return new bnbd(this);
  }
  
  public void a()
  {
    super.a();
    a(bmiu.class, this);
  }
  
  public void a(int paramInt, bmzd parambmzd)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambmzd.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambmzd.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambmzd.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bmzd = parambmzd;
    }
  }
  
  public void a(Bundle paramBundle, bmzd parambmzd)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambmzd);
  }
  
  public void a(bmqr parambmqr, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bmou.a(localBundle, parambmqr);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bmnj.a(38, localBundle);
    parambmqr.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bmzd = new bmzd(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bmza != null) && (this.jdField_a_of_type_Bmza.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bnaz parambnaz)
  {
    bmzd localbmzd = a();
    if (localbmzd != null)
    {
      ((blsg)blqr.a(15)).a(null);
      String str = a(localbmzd);
      if (!TextUtils.isEmpty(str))
      {
        wxe.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambnaz.a.putExtra("i_l", str);
        wxj.a("video_edit", "pub_vote", 2, 0, new String[] { localbmzd.jdField_a_of_type_ArrayOfJavaLangString[0] });
        wxj.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    wxe.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
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
    wxj.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      wxe.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bmzd = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bmzd localbmzd = a();
    if (localbmzd == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbmzd.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbmzd.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbmzd.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bdgm.a(a(), 230, alud.a(2131704182), null, alud.a(2131704246), alud.a(2131704202), new bmyy(this), new bmyz(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bmnj.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyx
 * JD-Core Version:    0.7.0.1
 */