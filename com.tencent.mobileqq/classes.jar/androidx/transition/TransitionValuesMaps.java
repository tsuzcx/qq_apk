package androidx.transition;

import android.util.SparseArray;
import android.view.View;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;

class TransitionValuesMaps
{
  final SparseArray<View> mIdValues = new SparseArray();
  final LongSparseArray<View> mItemIdValues = new LongSparseArray();
  final ArrayMap<String, View> mNameValues = new ArrayMap();
  final ArrayMap<View, TransitionValues> mViewValues = new ArrayMap();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TransitionValuesMaps
 * JD-Core Version:    0.7.0.1
 */