import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.ArrowKeyMovementMethod;
import android.text.style.ImageSpan;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class awmf
  extends ArrowKeyMovementMethod
  implements bkpw
{
  private static awmf jdField_a_of_type_Awmf;
  private int jdField_a_of_type_Int;
  private Class jdField_a_of_type_JavaLangClass;
  private WeakReference<aglj> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private WeakReference<BaseChatPie> jdField_b_of_type_MqqUtilWeakReference;
  private int c;
  
  public static awmf a(int paramInt, Class<? extends ImageSpan> paramClass)
  {
    if (jdField_a_of_type_Awmf == null) {
      jdField_a_of_type_Awmf = new awmf();
    }
    jdField_a_of_type_Awmf.c = paramInt;
    jdField_a_of_type_Awmf.jdField_a_of_type_JavaLangClass = paramClass;
    return jdField_a_of_type_Awmf;
  }
  
  public static void a()
  {
    if (jdField_a_of_type_Awmf != null) {
      jdField_a_of_type_Awmf.jdField_a_of_type_Boolean = true;
    }
  }
  
  public static void a(aglj paramaglj)
  {
    if (jdField_a_of_type_Awmf != null)
    {
      if (paramaglj != null) {
        jdField_a_of_type_Awmf.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramaglj);
      }
    }
    else {
      return;
    }
    jdField_a_of_type_Awmf.jdField_a_of_type_MqqUtilWeakReference = null;
  }
  
  public static void a(BaseChatPie paramBaseChatPie)
  {
    if (jdField_a_of_type_Awmf != null)
    {
      if (paramBaseChatPie != null) {
        jdField_a_of_type_Awmf.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramBaseChatPie);
      }
    }
    else {
      return;
    }
    jdField_a_of_type_Awmf.jdField_b_of_type_MqqUtilWeakReference = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
    }
    int j;
    int m;
    int k;
    Object[] arrayOfObject;
    int n;
    int i1;
    boolean bool;
    if (paramMotionEvent.getAction() == 1)
    {
      i = (int)paramMotionEvent.getX();
      j = (int)paramMotionEvent.getY();
      if ((Math.abs(this.jdField_a_of_type_Int - i) < 10) && (Math.abs(this.jdField_b_of_type_Int - j) < 10))
      {
        m = paramTextView.getTotalPaddingLeft();
        k = paramTextView.getTotalPaddingTop();
        i = i - m + paramTextView.getScrollX();
        j = j - k + paramTextView.getScrollY();
        Layout localLayout = paramTextView.getLayout();
        m = localLayout.getLineForVertical(j);
        k = localLayout.getOffsetForHorizontal(m, i);
        arrayOfObject = paramSpannable.getSpans(k, k, this.jdField_a_of_type_JavaLangClass);
        if (arrayOfObject.length > 0)
        {
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(arrayOfObject[0]), paramSpannable.getSpanEnd(arrayOfObject[0]));
          paramSpannable = (BaseChatPie)this.jdField_b_of_type_MqqUtilWeakReference.get();
          if ((!(arrayOfObject[0] instanceof ImageSpan)) || (paramSpannable == null)) {
            return false;
          }
          k = localLayout.getLineTop(m);
          m = localLayout.getLineBottom(m);
          n = paramTextView.getTotalPaddingLeft();
          paramMotionEvent = ((ImageSpan)arrayOfObject[0]).getDrawable().getBounds();
          i1 = paramMotionEvent.width();
          if ((i < this.c) || (i > i1 + this.c)) {
            return false;
          }
          if ((j < k) || (j > m)) {
            return false;
          }
          i1 = m - paramMotionEvent.height() - paramTextView.getScrollY() + paramTextView.getTotalPaddingTop() + bqcd.a(BaseApplicationImpl.getContext());
          if ((this.jdField_a_of_type_MqqUtilWeakReference != null) && (this.jdField_a_of_type_MqqUtilWeakReference.get() != null) && (((aglj)this.jdField_a_of_type_MqqUtilWeakReference.get()).a()))
          {
            bool = true;
            if (bool) {
              break label730;
            }
            j = bggq.a(BaseApplicationImpl.getApplication()).jdField_b_of_type_Int;
          }
        }
      }
    }
    for (int i = afur.a(50.0F, BaseApplicationImpl.getApplication().getResources());; i = 0)
    {
      if (bool) {}
      for (paramTextView = new Rect(paramMotionEvent.left + n, paramMotionEvent.top + i1, paramMotionEvent.left + n + paramMotionEvent.width(), i1 + (paramMotionEvent.top + paramMotionEvent.height()));; paramTextView = new Rect(paramMotionEvent.left + n, j - paramMotionEvent.height() - i, paramMotionEvent.left + n + paramMotionEvent.width(), j - i))
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkMovementMethodExt", 2, "fullState:" + bool + ", top:" + k + ", bottom:" + m + ",padLeft:" + n + ", screenH:" + j + ", panelH:" + i + ", bounds:" + paramMotionEvent + ", rect:" + paramTextView);
        }
        if (paramSpannable.a != null)
        {
          paramMotionEvent = new Intent(paramSpannable.a, NewPhotoPreviewActivity.class);
          paramMotionEvent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", ((ImageSpan)arrayOfObject[0]).getSource());
          paramMotionEvent.putExtra("input_full_screen_click", true);
          paramMotionEvent.putExtra("PhotoConst.SHOW_ALBUM", false);
          paramMotionEvent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", false);
          paramMotionEvent.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", false);
          paramMotionEvent.putExtra("showFlashPic", false);
          paramMotionEvent.putExtra("KEY_THUMBNAL_BOUND", paramTextView);
          paramMotionEvent.putExtra("enter_from", 1);
          paramMotionEvent.addFlags(603979776);
          paramSpannable.a.startActivity(paramMotionEvent);
          paramSpannable.aJ();
        }
        this.jdField_a_of_type_Boolean = false;
        return true;
        bool = false;
        break;
      }
      this.jdField_a_of_type_Boolean = true;
      return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
      label730:
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awmf
 * JD-Core Version:    0.7.0.1
 */