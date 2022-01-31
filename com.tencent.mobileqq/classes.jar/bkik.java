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

public class bkik
  extends bjwu
  implements DialogInterface.OnDismissListener, bjsh
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bkin jdField_a_of_type_Bkin;
  @Nullable
  private bkiq jdField_a_of_type_Bkiq;
  private float b;
  private float c;
  private float d;
  
  public bkik(@NonNull bjww parambjww)
  {
    super(parambjww);
  }
  
  private String a(bkiq parambkiq)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bkae localbkae = (bkae)a().a();
      if (localbkae == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambkiq = new JSONArray(Arrays.asList(parambkiq.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambkiq);
        parambkiq = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzo.a(a())), Integer.valueOf(vzo.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkae.u * localbkae.q), Float.valueOf(localbkae.v * localbkae.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkae.b.x + localbkae.s), Float.valueOf(localbkae.b.y + localbkae.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambkiq);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbkae.r);
        localJSONObject1.put("a", localJSONObject2);
        parambkiq = localJSONObject1.toString();
        return parambkiq;
      }
      catch (JSONException parambkiq)
      {
        veg.e("Q.qqstory.publish.editEditVideoInteract", parambkiq.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bkin != null) && (this.jdField_a_of_type_Bkin.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bkin = new bkin(a(), this, paramInt);
    this.jdField_a_of_type_Bkin.a(a());
    this.jdField_a_of_type_Bkin.setContentView(2131561443);
    this.jdField_a_of_type_Bkin.setOnDismissListener(this);
    this.jdField_a_of_type_Bkin.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bkin != null) && (this.jdField_a_of_type_Bkin.isShowing()))
    {
      this.jdField_a_of_type_Bkin.dismiss();
      this.jdField_a_of_type_Bkin = null;
    }
  }
  
  public Bitmap a()
  {
    bkad localbkad = a();
    if (localbkad.a()) {}
    for (;;)
    {
      return null;
      int i = localbkad.a.width();
      int j = localbkad.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbkad.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        veg.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bkad a()
  {
    Object localObject = (bjsd)a(bjsd.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bjsd)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bkiq a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bkiq;
  }
  
  public JobSegment<bkkm, bkkm> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bjww.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bjww.a.a instanceof EditLocalVideoSource))) {
      return new bkky(this);
    }
    return new bkkq(this);
  }
  
  public void a()
  {
    super.a();
    a(bjsh.class, this);
  }
  
  public void a(int paramInt, bkiq parambkiq)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambkiq.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambkiq.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambkiq.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bkiq = parambkiq;
    }
  }
  
  public void a(Bundle paramBundle, bkiq parambkiq)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambkiq);
  }
  
  public void a(bkae parambkae, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bjyh.a(localBundle, parambkae);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjww.a(38, localBundle);
    parambkae.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bkiq = new bkiq(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkin != null) && (this.jdField_a_of_type_Bkin.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bkkm parambkkm)
  {
    bkiq localbkiq = a();
    if (localbkiq != null)
    {
      ((bjbt)bjae.a(15)).a(null);
      String str = a(localbkiq);
      if (!TextUtils.isEmpty(str))
      {
        veg.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambkkm.a.putExtra("i_l", str);
        vel.a("video_edit", "pub_vote", 2, 0, new String[] { localbkiq.jdField_a_of_type_ArrayOfJavaLangString[0] });
        vel.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    veg.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
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
    vel.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      veg.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bkiq = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bkiq localbkiq = a();
    if (localbkiq == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbkiq.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbkiq.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbkiq.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bbcv.a(a(), 230, ajyc.a(2131703787), null, ajyc.a(2131703851), ajyc.a(2131703807), new bkil(this), new bkim(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bjww.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkik
 * JD-Core Version:    0.7.0.1
 */