package androidx.appcompat.app;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ListAdapter;
import android.widget.SimpleCursorAdapter;

public class AlertController$AlertParams
{
  public ListAdapter mAdapter;
  public boolean mCancelable;
  public int mCheckedItem = -1;
  public boolean[] mCheckedItems;
  public final Context mContext;
  public Cursor mCursor;
  public View mCustomTitleView;
  public boolean mForceInverseBackground;
  public Drawable mIcon;
  public int mIconAttrId = 0;
  public int mIconId = 0;
  public final LayoutInflater mInflater;
  public String mIsCheckedColumn;
  public boolean mIsMultiChoice;
  public boolean mIsSingleChoice;
  public CharSequence[] mItems;
  public String mLabelColumn;
  public CharSequence mMessage;
  public Drawable mNegativeButtonIcon;
  public DialogInterface.OnClickListener mNegativeButtonListener;
  public CharSequence mNegativeButtonText;
  public Drawable mNeutralButtonIcon;
  public DialogInterface.OnClickListener mNeutralButtonListener;
  public CharSequence mNeutralButtonText;
  public DialogInterface.OnCancelListener mOnCancelListener;
  public DialogInterface.OnMultiChoiceClickListener mOnCheckboxClickListener;
  public DialogInterface.OnClickListener mOnClickListener;
  public DialogInterface.OnDismissListener mOnDismissListener;
  public AdapterView.OnItemSelectedListener mOnItemSelectedListener;
  public DialogInterface.OnKeyListener mOnKeyListener;
  public AlertController.AlertParams.OnPrepareListViewListener mOnPrepareListViewListener;
  public Drawable mPositiveButtonIcon;
  public DialogInterface.OnClickListener mPositiveButtonListener;
  public CharSequence mPositiveButtonText;
  public boolean mRecycleOnMeasure = true;
  public CharSequence mTitle;
  public View mView;
  public int mViewLayoutResId;
  public int mViewSpacingBottom;
  public int mViewSpacingLeft;
  public int mViewSpacingRight;
  public boolean mViewSpacingSpecified = false;
  public int mViewSpacingTop;
  
  public AlertController$AlertParams(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCancelable = true;
    this.mInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void createListView(AlertController paramAlertController)
  {
    AlertController.RecycleListView localRecycleListView = (AlertController.RecycleListView)this.mInflater.inflate(paramAlertController.mListLayout, null);
    if (this.mIsMultiChoice)
    {
      localObject = this.mCursor;
      if (localObject == null) {
        localObject = new AlertController.AlertParams.1(this, this.mContext, paramAlertController.mMultiChoiceItemLayout, 16908308, this.mItems, localRecycleListView);
      } else {
        localObject = new AlertController.AlertParams.2(this, this.mContext, (Cursor)localObject, false, localRecycleListView, paramAlertController);
      }
    }
    else
    {
      int i;
      if (this.mIsSingleChoice) {
        i = paramAlertController.mSingleChoiceItemLayout;
      } else {
        i = paramAlertController.mListItemLayout;
      }
      localObject = this.mCursor;
      if (localObject != null)
      {
        localObject = new SimpleCursorAdapter(this.mContext, i, (Cursor)localObject, new String[] { this.mLabelColumn }, new int[] { 16908308 });
      }
      else
      {
        localObject = this.mAdapter;
        if (localObject == null) {
          localObject = new AlertController.CheckedItemAdapter(this.mContext, i, 16908308, this.mItems);
        }
      }
    }
    AlertController.AlertParams.OnPrepareListViewListener localOnPrepareListViewListener = this.mOnPrepareListViewListener;
    if (localOnPrepareListViewListener != null) {
      localOnPrepareListViewListener.onPrepareListView(localRecycleListView);
    }
    paramAlertController.mAdapter = ((ListAdapter)localObject);
    paramAlertController.mCheckedItem = this.mCheckedItem;
    if (this.mOnClickListener != null) {
      localRecycleListView.setOnItemClickListener(new AlertController.AlertParams.3(this, paramAlertController));
    } else if (this.mOnCheckboxClickListener != null) {
      localRecycleListView.setOnItemClickListener(new AlertController.AlertParams.4(this, localRecycleListView, paramAlertController));
    }
    Object localObject = this.mOnItemSelectedListener;
    if (localObject != null) {
      localRecycleListView.setOnItemSelectedListener((AdapterView.OnItemSelectedListener)localObject);
    }
    if (this.mIsSingleChoice) {
      localRecycleListView.setChoiceMode(1);
    } else if (this.mIsMultiChoice) {
      localRecycleListView.setChoiceMode(2);
    }
    paramAlertController.mListView = localRecycleListView;
  }
  
  public void apply(AlertController paramAlertController)
  {
    Object localObject = this.mCustomTitleView;
    if (localObject != null)
    {
      paramAlertController.setCustomTitle((View)localObject);
    }
    else
    {
      localObject = this.mTitle;
      if (localObject != null) {
        paramAlertController.setTitle((CharSequence)localObject);
      }
      localObject = this.mIcon;
      if (localObject != null) {
        paramAlertController.setIcon((Drawable)localObject);
      }
      i = this.mIconId;
      if (i != 0) {
        paramAlertController.setIcon(i);
      }
      i = this.mIconAttrId;
      if (i != 0) {
        paramAlertController.setIcon(paramAlertController.getIconAttributeResId(i));
      }
    }
    localObject = this.mMessage;
    if (localObject != null) {
      paramAlertController.setMessage((CharSequence)localObject);
    }
    if ((this.mPositiveButtonText != null) || (this.mPositiveButtonIcon != null)) {
      paramAlertController.setButton(-1, this.mPositiveButtonText, this.mPositiveButtonListener, null, this.mPositiveButtonIcon);
    }
    if ((this.mNegativeButtonText != null) || (this.mNegativeButtonIcon != null)) {
      paramAlertController.setButton(-2, this.mNegativeButtonText, this.mNegativeButtonListener, null, this.mNegativeButtonIcon);
    }
    if ((this.mNeutralButtonText != null) || (this.mNeutralButtonIcon != null)) {
      paramAlertController.setButton(-3, this.mNeutralButtonText, this.mNeutralButtonListener, null, this.mNeutralButtonIcon);
    }
    if ((this.mItems != null) || (this.mCursor != null) || (this.mAdapter != null)) {
      createListView(paramAlertController);
    }
    localObject = this.mView;
    if (localObject != null)
    {
      if (this.mViewSpacingSpecified)
      {
        paramAlertController.setView((View)localObject, this.mViewSpacingLeft, this.mViewSpacingTop, this.mViewSpacingRight, this.mViewSpacingBottom);
        return;
      }
      paramAlertController.setView((View)localObject);
      return;
    }
    int i = this.mViewLayoutResId;
    if (i != 0) {
      paramAlertController.setView(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.app.AlertController.AlertParams
 * JD-Core Version:    0.7.0.1
 */