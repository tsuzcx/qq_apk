class bjtg
  implements bkju<Boolean, bkjz>
{
  bjtg(bjte parambjte) {}
  
  public Void a(Boolean paramBoolean, bkjz parambkjz)
  {
    if ((!paramBoolean.booleanValue()) || (parambkjz == null) || (parambkjz.jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail error! thumbnail = (null)");
      return null;
    }
    ved.b("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d", Integer.valueOf(parambkjz.jdField_a_of_type_Int));
    if (parambkjz.jdField_a_of_type_Int >= this.a.a.length)
    {
      ved.e("Q.qqstory.record.EditLocalVideoPlayer", "Generate thumbnail index = %d OutOfArrayBounds", new Object[] { Integer.valueOf(parambkjz.jdField_a_of_type_Int) });
      return null;
    }
    ved.b("Q.qqstory.record.EditLocalVideoPlayer.Flow", "thumbnailProgress index: %d thumbnail done!", Integer.valueOf(parambkjz.jdField_a_of_type_Int));
    this.a.a[parambkjz.jdField_a_of_type_Int] = bjth.a(this.a.a[parambkjz.jdField_a_of_type_Int], parambkjz.jdField_a_of_type_AndroidGraphicsBitmap);
    this.a.a[parambkjz.jdField_a_of_type_Int].jdField_a_of_type_JavaLangString = parambkjz.jdField_a_of_type_JavaLangString;
    this.a.j();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bjtg
 * JD-Core Version:    0.7.0.1
 */