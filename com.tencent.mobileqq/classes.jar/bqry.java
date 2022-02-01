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

public class bqry
  extends bqgi
  implements DialogInterface.OnDismissListener, bqbv
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bqsb jdField_a_of_type_Bqsb;
  @Nullable
  private bqse jdField_a_of_type_Bqse;
  private float b;
  private float c;
  private float d;
  
  public bqry(@NonNull bqgk parambqgk)
  {
    super(parambqgk);
  }
  
  private String a(bqse parambqse)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bqjs localbqjs = (bqjs)a().a();
      if (localbqjs == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambqse = new JSONArray(Arrays.asList(parambqse.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambqse);
        parambqse = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(zps.a(a())), Integer.valueOf(zps.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqjs.u * localbqjs.q), Float.valueOf(localbqjs.v * localbqjs.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbqjs.b.x + localbqjs.s), Float.valueOf(localbqjs.b.y + localbqjs.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambqse);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbqjs.r);
        localJSONObject1.put("a", localJSONObject2);
        parambqse = localJSONObject1.toString();
        return parambqse;
      }
      catch (JSONException parambqse)
      {
        yuk.e("Q.qqstory.publish.editEditVideoInteract", parambqse.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bqsb != null) && (this.jdField_a_of_type_Bqsb.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bqsb = new bqsb(a(), this, paramInt);
    this.jdField_a_of_type_Bqsb.a(a());
    this.jdField_a_of_type_Bqsb.setContentView(2131561925);
    this.jdField_a_of_type_Bqsb.setOnDismissListener(this);
    this.jdField_a_of_type_Bqsb.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bqsb != null) && (this.jdField_a_of_type_Bqsb.isShowing()))
    {
      this.jdField_a_of_type_Bqsb.dismiss();
      this.jdField_a_of_type_Bqsb = null;
    }
  }
  
  public Bitmap a()
  {
    bqjr localbqjr = a();
    if (localbqjr.a()) {}
    for (;;)
    {
      return null;
      int i = localbqjr.a.width();
      int j = localbqjr.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbqjr.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        yuk.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bqjr a()
  {
    Object localObject = (bqbr)a(bqbr.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bqbr)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bqse a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bqse;
  }
  
  public JobSegment<bqua, bqua> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bqgk.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bqgk.a.a instanceof EditLocalVideoSource))) {
      return new bqum(this);
    }
    return new bque(this);
  }
  
  public void a()
  {
    super.a();
    a(bqbv.class, this);
  }
  
  public void a(int paramInt, bqse parambqse)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambqse.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambqse.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambqse.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bqse = parambqse;
    }
  }
  
  public void a(Bundle paramBundle, bqse parambqse)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambqse);
  }
  
  public void a(bqjs parambqjs, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bqhv.a(localBundle, parambqjs);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bqgk.a(38, localBundle);
    parambqjs.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bqse = new bqse(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bqsb != null) && (this.jdField_a_of_type_Bqsb.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bqua parambqua)
  {
    bqse localbqse = a();
    if (localbqse != null)
    {
      ((bpnf)bplq.a(15)).a(null);
      String str = a(localbqse);
      if (!TextUtils.isEmpty(str))
      {
        yuk.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambqua.a.putExtra("i_l", str);
        yup.a("video_edit", "pub_vote", 2, 0, new String[] { localbqse.jdField_a_of_type_ArrayOfJavaLangString[0] });
        yup.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    yuk.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
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
    yup.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      yuk.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bqse = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bqse localbqse = a();
    if (localbqse == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbqse.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbqse.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbqse.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bhlq.a(a(), 230, anzj.a(2131702686), null, anzj.a(2131702750), anzj.a(2131702706), new bqrz(this), new bqsa(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bqgk.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqry
 * JD-Core Version:    0.7.0.1
 */