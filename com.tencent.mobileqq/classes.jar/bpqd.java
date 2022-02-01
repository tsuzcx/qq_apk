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

public class bpqd
  extends bpen
  implements DialogInterface.OnDismissListener, bpaa
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bpqg jdField_a_of_type_Bpqg;
  @Nullable
  private bpqj jdField_a_of_type_Bpqj;
  private float b;
  private float c;
  private float d;
  
  public bpqd(@NonNull bpep parambpep)
  {
    super(parambpep);
  }
  
  private String a(bpqj parambpqj)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bphx localbphx = (bphx)a().a();
      if (localbphx == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambpqj = new JSONArray(Arrays.asList(parambpqj.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambpqj);
        parambpqj = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zlx.a(a())), Integer.valueOf(zlx.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbphx.u * localbphx.q), Float.valueOf(localbphx.v * localbphx.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbphx.b.x + localbphx.s), Float.valueOf(localbphx.b.y + localbphx.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambpqj);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbphx.r);
        localJSONObject1.put("a", localJSONObject2);
        parambpqj = localJSONObject1.toString();
        return parambpqj;
      }
      catch (JSONException parambpqj)
      {
        yqp.e("Q.qqstory.publish.editEditVideoInteract", parambpqj.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bpqg != null) && (this.jdField_a_of_type_Bpqg.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bpqg = new bpqg(a(), this, paramInt);
    this.jdField_a_of_type_Bpqg.a(a());
    this.jdField_a_of_type_Bpqg.setContentView(2131561884);
    this.jdField_a_of_type_Bpqg.setOnDismissListener(this);
    this.jdField_a_of_type_Bpqg.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bpqg != null) && (this.jdField_a_of_type_Bpqg.isShowing()))
    {
      this.jdField_a_of_type_Bpqg.dismiss();
      this.jdField_a_of_type_Bpqg = null;
    }
  }
  
  public Bitmap a()
  {
    bphw localbphw = a();
    if (localbphw.a()) {}
    for (;;)
    {
      return null;
      int i = localbphw.a.width();
      int j = localbphw.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbphw.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        yqp.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bphw a()
  {
    Object localObject = (bozw)a(bozw.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bozw)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bpqj a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bpqj;
  }
  
  public JobSegment<bpsf, bpsf> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bpep.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bpep.a.a instanceof EditLocalVideoSource))) {
      return new bpsr(this);
    }
    return new bpsj(this);
  }
  
  public void a()
  {
    super.a();
    a(bpaa.class, this);
  }
  
  public void a(int paramInt, bpqj parambpqj)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambpqj.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambpqj.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambpqj.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bpqj = parambpqj;
    }
  }
  
  public void a(Bundle paramBundle, bpqj parambpqj)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambpqj);
  }
  
  public void a(bphx parambphx, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bpga.a(localBundle, parambphx);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bpep.a(38, localBundle);
    parambphx.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bpqj = new bpqj(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bpqg != null) && (this.jdField_a_of_type_Bpqg.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bpsf parambpsf)
  {
    bpqj localbpqj = a();
    if (localbpqj != null)
    {
      ((bolk)bojv.a(15)).a(null);
      String str = a(localbpqj);
      if (!TextUtils.isEmpty(str))
      {
        yqp.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambpsf.a.putExtra("i_l", str);
        yqu.a("video_edit", "pub_vote", 2, 0, new String[] { localbpqj.jdField_a_of_type_ArrayOfJavaLangString[0] });
        yqu.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    yqp.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
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
    yqu.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      yqp.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bpqj = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bpqj localbpqj = a();
    if (localbpqj == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbpqj.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbpqj.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbpqj.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bglp.a(a(), 230, anni.a(2131702579), null, anni.a(2131702643), anni.a(2131702599), new bpqe(this), new bpqf(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bpep.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bpqd
 * JD-Core Version:    0.7.0.1
 */