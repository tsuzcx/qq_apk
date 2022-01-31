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

public class bkjb
  extends bjxl
  implements DialogInterface.OnDismissListener, bjsy
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private bkje jdField_a_of_type_Bkje;
  @Nullable
  private bkjh jdField_a_of_type_Bkjh;
  private float b;
  private float c;
  private float d;
  
  public bkjb(@NonNull bjxn parambjxn)
  {
    super(parambjxn);
  }
  
  private String a(bkjh parambkjh)
  {
    int i = -1;
    switch (this.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      bkav localbkav = (bkav)a().a();
      if (localbkav == null) {
        break label304;
      }
      JSONObject localJSONObject1 = new JSONObject();
      try
      {
        parambkjh = new JSONArray(Arrays.asList(parambkjh.jdField_a_of_type_ArrayOfJavaLangString));
        localJSONObject1.put("t", i);
        localJSONObject1.put("c", parambkjh);
        parambkjh = new JSONArray(Arrays.asList(new Integer[] { Integer.valueOf(vzl.a(a())), Integer.valueOf(vzl.d(a())) }));
        JSONArray localJSONArray1 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkav.u * localbkav.q), Float.valueOf(localbkav.v * localbkav.q) }));
        JSONArray localJSONArray2 = new JSONArray(Arrays.asList(new Float[] { Float.valueOf(localbkav.b.x + localbkav.s), Float.valueOf(localbkav.b.y + localbkav.t) }));
        JSONObject localJSONObject2 = new JSONObject();
        localJSONObject2.put("ss", parambkjh);
        localJSONObject2.put("ls", localJSONArray1);
        localJSONObject2.put("lp", localJSONArray2);
        localJSONObject2.put("r", localbkav.r);
        localJSONObject1.put("a", localJSONObject2);
        parambkjh = localJSONObject1.toString();
        return parambkjh;
      }
      catch (JSONException parambkjh)
      {
        ved.e("Q.qqstory.publish.editEditVideoInteract", parambkjh.toString());
      }
      i = 1;
    }
    label304:
    return null;
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Bkje != null) && (this.jdField_a_of_type_Bkje.isShowing())) {
      d();
    }
    this.jdField_a_of_type_Bkje = new bkje(a(), this, paramInt);
    this.jdField_a_of_type_Bkje.a(a());
    this.jdField_a_of_type_Bkje.setContentView(2131561442);
    this.jdField_a_of_type_Bkje.setOnDismissListener(this);
    this.jdField_a_of_type_Bkje.show();
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_Bkje != null) && (this.jdField_a_of_type_Bkje.isShowing()))
    {
      this.jdField_a_of_type_Bkje.dismiss();
      this.jdField_a_of_type_Bkje = null;
    }
  }
  
  public Bitmap a()
  {
    bkau localbkau = a();
    if (localbkau.a()) {}
    for (;;)
    {
      return null;
      int i = localbkau.a.width();
      int j = localbkau.a.height();
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
        if (localBitmap != null)
        {
          localbkau.d(new Canvas(localBitmap));
          return localBitmap;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        ved.c("Q.qqstory.publish.editEditVideoInteract", "OutOfMemoryError :", localOutOfMemoryError);
      }
    }
    return null;
  }
  
  @NonNull
  public bkau a()
  {
    Object localObject = (bjsu)a(bjsu.class);
    if (localObject == null) {
      throw new IllegalStateException("can not get EditDoodleExport");
    }
    localObject = ((bjsu)localObject).a().a();
    if (localObject == null) {
      throw new IllegalStateException("InteractPasterLayer is null.");
    }
    return localObject;
  }
  
  public bkjh a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return null;
    }
    return this.jdField_a_of_type_Bkjh;
  }
  
  public JobSegment<bkld, bkld> a(int paramInt)
  {
    if (((this.jdField_a_of_type_Bjxn.a.a instanceof EditTakeVideoSource)) || ((this.jdField_a_of_type_Bjxn.a.a instanceof EditLocalVideoSource))) {
      return new bklp(this);
    }
    return new bklh(this);
  }
  
  public void a()
  {
    super.a();
    a(bjsy.class, this);
  }
  
  public void a(int paramInt, bkjh parambkjh)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      Bitmap localBitmap = parambkjh.jdField_a_of_type_AndroidGraphicsBitmap;
      a().a(localBitmap, parambkjh.jdField_a_of_type_ArrayOfAndroidGraphicsRect, parambkjh.jdField_a_of_type_ArrayOfJavaLangString, this.jdField_a_of_type_Float, this.b, this.c, this.d);
      return;
      this.jdField_a_of_type_Bkjh = parambkjh;
    }
  }
  
  public void a(Bundle paramBundle, bkjh parambkjh)
  {
    int i = paramBundle.getInt("interact_type");
    this.jdField_a_of_type_Float = paramBundle.getFloat("scale");
    this.b = paramBundle.getFloat("rotate");
    this.c = paramBundle.getFloat("translateX");
    this.d = paramBundle.getFloat("translateY");
    a(i, parambkjh);
  }
  
  public void a(bkav parambkav, float paramFloat1, float paramFloat2)
  {
    Bundle localBundle = new Bundle();
    bjyy.a(localBundle, parambkav);
    localBundle.putInt("interact_type", this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Bjxn.a(38, localBundle);
    parambkav.l = false;
  }
  
  public void a(@NonNull String[] paramArrayOfString, @NonNull Bitmap paramBitmap, @NonNull Rect[] paramArrayOfRect, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 1001;
    this.jdField_a_of_type_Bkjh = new bkjh(paramBitmap, paramArrayOfString, paramArrayOfRect, paramBoolean);
    a().a(paramBitmap, paramArrayOfRect, paramArrayOfString, paramFloat1, paramFloat2, paramFloat3, paramFloat4);
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_Bkje != null) && (this.jdField_a_of_type_Bkje.isShowing()))
    {
      d();
      return true;
    }
    return false;
  }
  
  public void a_(int paramInt, bkld parambkld)
  {
    bkjh localbkjh = a();
    if (localbkjh != null)
    {
      ((bjck)bjav.a(15)).a(null);
      String str = a(localbkjh);
      if (!TextUtils.isEmpty(str))
      {
        ved.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, interact json:%s", str);
        parambkld.a.putExtra("i_l", str);
        vei.a("video_edit", "pub_vote", 2, 0, new String[] { localbkjh.jdField_a_of_type_ArrayOfJavaLangString[0] });
        vei.a("video_edit_new", "qa_send", 2, 0, new String[0]);
      }
      return;
    }
    ved.a("Q.qqstory.publish.editEditVideoInteract", "editVideoPrePublish, paster info is null. type:%s", Integer.valueOf(this.jdField_a_of_type_Int));
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
    vei.a("video_edit", "clk_vote_entry", 2, 0, new String[0]);
  }
  
  public void b()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      ved.d("Q.qqstory.publish.editEditVideoInteract", "delete interact paster error:%s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int) });
    }
    for (;;)
    {
      this.jdField_a_of_type_Int = -1;
      return;
      this.jdField_a_of_type_Bkjh = null;
    }
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_Int == -1) {
      return true;
    }
    bkjh localbkjh = a();
    if (localbkjh == null) {
      return true;
    }
    int i = 0;
    for (;;)
    {
      if ((i >= localbkjh.jdField_a_of_type_ArrayOfJavaLangString.length) || (TextUtils.isEmpty(localbkjh.jdField_a_of_type_ArrayOfJavaLangString[i])))
      {
        if (i != localbkjh.jdField_a_of_type_ArrayOfJavaLangString.length) {
          break;
        }
        return true;
      }
      i += 1;
    }
    bbdj.a(a(), 230, ajya.a(2131703798), null, ajya.a(2131703862), ajya.a(2131703818), new bkjc(this), new bkjd(this)).show();
    return false;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    this.jdField_a_of_type_Bjxn.a(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkjb
 * JD-Core Version:    0.7.0.1
 */